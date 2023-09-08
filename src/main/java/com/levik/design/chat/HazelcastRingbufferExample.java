package com.levik.design.chat;

import com.hazelcast.config.Config;
import com.hazelcast.config.RingbufferConfig;
import com.hazelcast.core.*;
import com.hazelcast.map.IMap;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;
import com.hazelcast.ringbuffer.Ringbuffer;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HazelcastRingbufferExample {

    public static class Message implements DataSerializable {
        private String room;
        private long userId;
        private String message;

        public Message() {
        }

        public Message(String room, long userId, String message) {
            this.room = room;
            this.userId = userId;
            this.message = message;
        }

        // Getters and setters

        @Override
        public void writeData(ObjectDataOutput out) throws IOException {
            out.writeUTF(room);
            out.writeLong(userId);
            out.writeUTF(message);
        }

        @Override
        public void readData(ObjectDataInput in) throws IOException {
            room = in.readUTF();
            userId = in.readLong();
            message = in.readUTF();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Create a Hazelcast instance
        Config config = new Config();
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);

        // Create an IMap to store the Map<String, Ringbuffer<Message>>
        IMap<String, Ringbuffer<Message>> storageMap = hazelcastInstance.getMap("storageMap");

        // Put some data into the storageMap
        String key = "exampleKey";
        int ringbufferCapacity = 5;
        int ttlSeconds = 10;
        RingbufferConfig ringbufferConfig = new RingbufferConfig(key);
        ringbufferConfig.setCapacity(ringbufferCapacity);
        ringbufferConfig.setTimeToLiveSeconds(ttlSeconds);
        storageMap.put(key, hazelcastInstance.getRingbuffer(key));

        // Add messages to the ringbuffer
        Ringbuffer<Message> ringbuffer = storageMap.get(key);
        ringbuffer.add(new Message("Room 1", 1L, "Message 1"));
        ringbuffer.add(new Message("Room 1", 2L, "Message 2"));
        ringbuffer.add(new Message("Room 1", 3L, "Message 3"));

        // Wait for some time to simulate expiration
        TimeUnit.SECONDS.sleep(15);

        // Retrieve the messages from the ringbuffer
        long headSequence = ringbuffer.headSequence();
        long tailSequence = ringbuffer.tailSequence();
        for (long sequence = headSequence; sequence <= tailSequence; sequence++) {
            Message message = ringbuffer.readOne(sequence);
            System.out.println("Retrieved Message: " + message);
        }

        // Shutdown the Hazelcast instance
        hazelcastInstance.shutdown();
    }
}
