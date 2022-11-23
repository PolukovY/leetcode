package com.levik.leetcode.topKFrequent;

import java.util.*;

public class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequents = new TreeMap<>();

        for (String word : words) {
            frequents.put(word, frequents.getOrDefault(word, 0) + 1);
        }

        return frequents.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }
}
