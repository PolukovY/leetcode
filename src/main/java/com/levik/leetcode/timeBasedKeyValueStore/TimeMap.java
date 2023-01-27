package com.levik.leetcode.timeBasedKeyValueStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {

    private final Map<String, List<Pair>> storage;

    public TimeMap() {
        this.storage = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Pair> values = storage.getOrDefault(key, new ArrayList<>());
        values.add(new Pair(value, timestamp));
        storage.put(key, values);
    }

    public String get(String key, int timestamp) {
        List<Pair> values = storage.getOrDefault(key, new ArrayList<>());
        return binarySearch(timestamp, values);
    }


    private String binarySearch(int timestamp, List<Pair> values) {
        String res = "";
        int low = 0;
        int high = values.size() - 1;

        while (low - high < 1) {
            int m = low + (high - low) / 2;
            var pair = values.get(m);

            if (pair.timestamp <= timestamp) {
                res = pair.value;
                low = m + 1;
            } else {
                high = m - 1;
            }
        }

        return res;
    }


    private record Pair(String value, int timestamp) {
    }
}
