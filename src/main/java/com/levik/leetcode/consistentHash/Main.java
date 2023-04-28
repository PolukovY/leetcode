package com.levik.leetcode.consistentHash;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ConsistentHash<String> hashRing = new ConsistentHash<>(new CRC32Hash());
        hashRing.addNode("node1");
        hashRing.addNode("node2");
        hashRing.addNode("node3");

        Map<String, Integer> statistic = new HashMap<>();

        for (int i = 0; i < 1_000_000; i++) {
            String key = "some_key" + i;
            String node = hashRing.getNode(key);


            Integer count = statistic.getOrDefault(node, 0) + 1;
            statistic.put(node, count);
        }



        statistic.forEach((key, value) -> System.out.println("Key : " + key + " Value : " + value));
    }
}
