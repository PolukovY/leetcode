package com.levik.design.chat;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.EntryListener;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.hazelcast.map.MapEvent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HazelcastStorageExample {

    private static final int MAX_LIST_SIZE = 2;

    public static void main(String[] args) {
        // Create a Hazelcast instance
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

        // Create an IMap to store the Map<String, List<Message>>
        IMap<String, List<Message>> storageMap = hazelcastInstance.getMap("storageMap");

        // Register an EntryListener to listen for map events
        storageMap.addEntryListener(new StorageMapEntryListener(), true);


        // Put some data into the storageMap
        String key = "exampleKey";
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("Room 1", 1L, "Message 1"));
        messages.add(new Message("Room 1", 2L, "Message 2"));
        messages.add(new Message("Room 2", 3L, "Message 3"));

        storageMap.put(key, messages);

        // Retrieve the data from the storageMap
        List<Message> retrievedMessages = storageMap.get(key);
        System.out.println("Message size " + retrievedMessages.size());
        System.out.println("Retrieved Messages: " + retrievedMessages);

        // Shutdown the Hazelcast instance
        hazelcastInstance.shutdown();
    }

    private static class StorageMapEntryListener implements EntryListener<String, List<Message>> {
        @Override
        public void entryAdded(EntryEvent<String, List<Message>> event) {
            String key = event.getKey();
            List<Message> messages = event.getValue();
            trimListSize(messages);
        }

        private void trimListSize(List<Message> messages) {
            if (messages.size() > MAX_LIST_SIZE) {
                List<Message> sortedMessages = messages.stream()
                        .sorted(Comparator.comparingLong(Message::getTimestamp))
                        .toList();
                messages.clear();
                messages.addAll(sortedMessages.subList(sortedMessages.size() - MAX_LIST_SIZE, sortedMessages.size()));
            }
        }

        @Override
        public void entryRemoved(EntryEvent<String, List<Message>> event) {
            // Handle entry removal based on size
            String key = event.getKey();
            List<Message> messages = event.getOldValue();
            if (messages != null && messages.size() == MAX_LIST_SIZE) {
                // Remove the oldest item from the list
                messages.remove(0);
            }
        }

        @Override
        public void entryEvicted(EntryEvent<String, List<Message>> entryEvent) {

        }

        @Override
        public void entryExpired(EntryEvent<String, List<Message>> entryEvent) {

        }

        @Override
        public void entryUpdated(EntryEvent<String, List<Message>> entryEvent) {

        }

        @Override
        public void mapCleared(MapEvent mapEvent) {

        }

        @Override
        public void mapEvicted(MapEvent mapEvent) {

        }

        // Other overridden methods (entryUpdated, entryEvicted, etc.)
        // You can choose to handle other events if needed
        // For example, you might want to handle entryUpdated to update the TTL of the list
    }

    public static class Message implements java.io.Serializable {
        private static final long serialVersionUID = 1L;
        private String room;
        private long userId;
        private String message;

        private long timestamp;

        public Message(String room, long userId, String message) {
            this.room = room;
            this.userId = userId;
            this.message = message;
            this.timestamp = System.currentTimeMillis();
        }

        public String getRoom() {
            return room;
        }

        public long getUserId() {
            return userId;
        }

        public String getMessage() {
            return message;
        }

        public long getTimestamp() {
            return timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Message message1 = (Message) o;
            return userId == message1.userId && timestamp == message1.timestamp && Objects.equals(room, message1.room) && Objects.equals(message, message1.message);
        }

        @Override
        public int hashCode() {
            return Objects.hash(room, userId, message, timestamp);
        }

        @Override
        public String toString() {
            return "Message{" +
                    "room='" + room + '\'' +
                    ", userId=" + userId +
                    ", message='" + message + '\'' +
                    ", timestamp=" + timestamp +
                    '}';
        }
    }
}

