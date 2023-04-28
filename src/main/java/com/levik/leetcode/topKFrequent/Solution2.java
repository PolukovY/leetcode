package com.levik.leetcode.topKFrequent;

import java.util.*;

public class Solution2 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int current = map.getOrDefault(num, 0);
            map.put(num, current + 1);
        }

        if (map.size() == 1) {
            return new int[]{map.keySet().stream().findFirst().get()};
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        heap.addAll(map.entrySet());

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> poll = heap.poll();
            res[i] = poll.getValue();
        }

        return res;
    }
}
