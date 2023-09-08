package com.levik.design.chat;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        var hazelcastInstance = Hazelcast.newHazelcastInstance();

        var inMemoryMessageMap = new HazelcastInMemoryMessageMap(hazelcastInstance);

        inMemoryMessageMap.add(new Message("House of Card", 1234, "Hi all", 1686304167182l), new ExpiredTime(30, TimeUnit.SECONDS));
        inMemoryMessageMap.add(new Message("House of Card", 235, "All good", 1686304167182l), new ExpiredTime(50, TimeUnit.SECONDS));
        inMemoryMessageMap.add(new Message("House of Card", 156, "Ping", 1686304167182l), new ExpiredTime(50, TimeUnit.SECONDS));
        inMemoryMessageMap.add(new Message("House of Card", 789, "Lol", 1686304167182l), new ExpiredTime(50, TimeUnit.SECONDS));
        inMemoryMessageMap.add(new Message("House of Card", 888, "Test", 1686304167182l), new ExpiredTime(50, TimeUnit.SECONDS));

        System.out.println();
        System.out.println("Messages: " + inMemoryMessageMap.size());
        inMemoryMessageMap.getMessages()
                .forEach(System.out::println);

        // Wait for 15 seconds
        System.out.println("Sleep 30 seconds");
        TimeUnit.SECONDS.sleep(30);


        System.out.println("Messages: " + inMemoryMessageMap.size());
        inMemoryMessageMap.getMessages()
                        .forEach(System.out::println);

        // Shutdown Hazelcast instance
        hazelcastInstance.shutdown();
    }

    public static class HazelcastInMemoryMessageMap implements InMemoryMap<Message>{
        private static final String EXPIRATION_MAP = "expirationMap";
        private final HazelcastInstance hazelcastInstance;

        private final Object lock;
        private final IMap<Long, List<Message>> mapWitExpiration;

        public HazelcastInMemoryMessageMap(HazelcastInstance hazelcastInstance) {
            this.hazelcastInstance = hazelcastInstance;
            this.mapWitExpiration = hazelcastInstance.getMap(EXPIRATION_MAP);
            this.lock = new Object();
        }

        @Override
        public void add(Message message, ExpiredTime expiredTime) {
            List<Message> messages = createListIfFirstMessage(message);
            addHelper(messages, expiredTime);
            System.out.println("Add message " + message + " with expiredTime " + expiredTime);
        }


        @Override
        public List<Message> getMessages() {
            return mapWitExpiration.entrySet().stream()
                    .filter(entry -> entry.getKey() > getCurrentTimestamp())
                    .flatMap(entry -> entry.getValue().stream())
                    .collect(Collectors.toList());
        }

        @Override
        public List<Message> getExpiredMessages() {
            return mapWitExpiration.entrySet().stream()
                    .filter(entry -> entry.getKey() <= getCurrentTimestamp())
                    .flatMap(entry -> {
                        long expirationTimestamp = entry.getKey();
                        List<Message> messages = entry.getValue();
                        mapWitExpiration.remove(expirationTimestamp);
                        return messages != null ? messages.stream() : Stream.empty();
                    })
                    .collect(Collectors.toList());
        }

        @Override
        public int size() {
            return mapWitExpiration.size();
        }

        @Override
        public void shutdown() {
            hazelcastInstance.shutdown();
        }

        private void addHelper(List<Message> messages, ExpiredTime expiredTime) {
            long expirationTimeMillis = getCurrentTimestamp() + expiredTime.timeUnit.toMillis(expiredTime.ttl);
            mapWitExpiration.put(expirationTimeMillis, messages);
        }

        private List<Message> createListIfFirstMessage(Message message) {
            synchronized (lock) {
                List<Message> messages = mapWitExpiration.getOrDefault(message.createAt, new ArrayList<>());
                messages.add(message);
                return messages;
            }
        }

        private long getCurrentTimestamp() {
            return System.currentTimeMillis();
        }
    }

    public interface InMemoryMap<T> {

        void add(T message, ExpiredTime expiredTime);

        List<Message> getMessages();

        int size();

        List<Message> getExpiredMessages();
        void shutdown();
    }

    public static class Message implements Serializable {
        @Serial
        private static final long serialVersionUID = -7430874749051106839L;
        private final String room;
        private final long userId;
        private final String message;
        private final long createAt;

        public Message(String room, long userId, String message, long createAt) {
            this.room = room;
            this.userId = userId;
            this.message = message;
            this.createAt = createAt;
        }

        public java.lang.String getRoom() {
            return room;
        }

        public long getUserId() {
            return userId;
        }

        public String getMessage() {
            return message;
        }

        public long getCreateAt() {
            return createAt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Message message1 = (Message) o;
            return userId == message1.userId && createAt == message1.createAt && Objects.equals(room, message1.room) && Objects.equals(message, message1.message);
        }

        @Override
        public int hashCode() {
            return Objects.hash(room, userId, message, createAt);
        }

        @Override
        public String toString() {
            return "Message{" +
                    "room='" + room + '\'' +
                    ", userId=" + userId +
                    ", message='" + message + '\'' +
                    ", createAt=" + createAt +
                    '}';
        }
    }

    public static class ExpiredTime implements Serializable {

        @Serial
        private static final long serialVersionUID = -5483331168934142350L;

        private final long ttl;
        private final TimeUnit timeUnit;

        public ExpiredTime(long ttl, TimeUnit timeUnit) {
            this.ttl = ttl;
            this.timeUnit = timeUnit;
        }

        public long getTtl() {
            return ttl;
        }

        public java.util.concurrent.TimeUnit getTimeUnit() {
            return timeUnit;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ExpiredTime that = (ExpiredTime) o;
            return ttl == that.ttl && timeUnit == that.timeUnit;
        }

        @Override
        public int hashCode() {
            return Objects.hash(ttl, timeUnit);
        }

        @Override
        public String toString() {
            return "ExpiredTime{" +
                    "ttl=" + ttl +
                    ", timeUnit=" + timeUnit +
                    '}';
        }
    }
}
