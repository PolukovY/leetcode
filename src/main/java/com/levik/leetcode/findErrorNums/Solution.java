package com.levik.leetcode.findErrorNums;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    //time O(n), space O(n)
    public int[] findErrorNums(int[] nums) {
        int duplicate = -1;
        int missing = 1;

        Map<Integer, Integer> map = populateNumWithCounter(nums);

        for (int i = 1; i<= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    duplicate = i;
                }
            } else {
                missing = i;
            }
        }

        return new int[] {duplicate, missing};
    }

    private Map<Integer, Integer> populateNumWithCounter(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map;
    }
}
