package com.levik.leetcode.topKFrequent;

import java.util.*;

public class Solution2 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int current = map.getOrDefault(num, 0);
            map.put(num, current + 1);
        }

        int[] counting = new int[nums.length + 1];
        map.forEach((key, value) ->
                counting[key] = value
        );

        int[] res = new int[k];
        int index = 0;

        for (int i = counting.length - 1; i > 0; i--) {
            if (index == k) {
                break;
            }
            int count = counting[i];
            if (count != 0) {
                res[index] = count;
                index++;
            }
        }

        return res;
    }
}
