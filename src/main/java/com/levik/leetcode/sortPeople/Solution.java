package com.levik.leetcode.sortPeople;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> group = new HashMap<>();

        for (int i = 0; i < heights.length; i++) {
            group.put(heights[i], names[i]);
        }

        Arrays.sort(heights);

        String[] result = new String[names.length];
        int k = 0;

        for (int i = result.length - 1; i >= 0; i--) {
            result[k] = group.get(heights[i]);
            k++;
        }

        return result;
    }
}
