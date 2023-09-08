package com.levik.design.chat;

import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NestedIMapWithTTLExample {
    private static final String OUTER_MAP = "outerMap";
    private static final HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

    public static void main(String[] args) throws InterruptedException {


        // Configure TTL for the inner IMap
        MapConfig innerMapConfig = new MapConfig();
        innerMapConfig.setName(OUTER_MAP);
        innerMapConfig.setTimeToLiveSeconds(30); // Set TTL to 30 seconds
        hazelcastInstance.getConfig().addMapConfig(innerMapConfig);

        IMap<String, IMap<Long, List<String>>> outerMap = hazelcastInstance.getMap(OUTER_MAP);

        // Add data to the nested IMap with TTL
        addDataWithTTL(outerMap, "key1", 2L, "Item1", 10, TimeUnit.SECONDS);
        addDataWithTTL(outerMap, "key1", 2L, "Item2", 20, TimeUnit.SECONDS);
        addDataWithTTL(outerMap, "key2", 4L, "Item3", 5, TimeUnit.SECONDS);
        addDataWithTTL(outerMap, "key2", 4L, "Item4", 15, TimeUnit.SECONDS);

        // Wait for TTL expiration
        TimeUnit.SECONDS.sleep(25); // Wait for TTL expiration

        // Retrieve the data from the nested IMap
        List<String> items = getData(outerMap, "key1", 2L);
        System.out.println("Items: " + items); // Output: [Item2]

        // Shutdown Hazelcast instance
        hazelcastInstance.shutdown();
    }

    private static void addDataWithTTL(IMap<String, IMap<Long, List<String>>> outerMap,
                                       String outerKey, Long innerKey, String item, long ttl, TimeUnit timeUnit) {
        IMap<Long, List<String>> innerMap = outerMap.get(outerKey);
        if (innerMap == null) {
            IMap<Long, List<String>> map = hazelcastInstance.getMap(outerKey);
            innerMap = outerMap.putIfAbsent(outerKey, map);
            if (innerMap == null) {
                innerMap = outerMap.get(outerKey);
            }
        }

        List<String> itemList = innerMap.get(innerKey);
        if (itemList == null) {
            itemList = new ArrayList<>();
        }
        itemList.add(item);
        innerMap.put(innerKey, itemList, ttl, timeUnit);
    }

    private static List<String> getData(IMap<String, IMap<Long, List<String>>> outerMap, String outerKey, Long innerKey) {
        IMap<Long, List<String>> innerMap = outerMap.get(outerKey);
        if (innerMap != null) {
            return innerMap.get(innerKey);
        }
        return null;
    }
}
