package com.levik.leetcode.consistentHash;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHash<T> {

    private final SortedMap<Long, T> hashRing;
    private final Map<T, Long> nodeToHash;
    private final HashFunction hashFunction;

    public ConsistentHash(HashFunction hashFunction) {
        this.hashFunction = hashFunction;
        this.hashRing = new TreeMap<>();
        this.nodeToHash = new HashMap<>();
    }

    public void addNode(T node) {
        long hash = hashFunction.hash(node.toString());
        hashRing.put(hash, node);
        nodeToHash.put(node, hash);
    }

    public void removeNode(T node) {
        Long hash = nodeToHash.get(node);
        if (hash != null) {
            hashRing.remove(hash);
            nodeToHash.remove(node);
        }
    }

    public int size() {
        return hashRing.size();
    }

    public T getNode(String key) {
        if (hashRing.isEmpty()) {
            return null;
        }
        long hash = hashFunction.hash(key);
        if (!hashRing.containsKey(hash)) {
            SortedMap<Long, T> tailMap = hashRing.tailMap(hash);
            hash = tailMap.isEmpty() ? hashRing.firstKey() : tailMap.firstKey();
        }
        return hashRing.get(hash);
    }
}
