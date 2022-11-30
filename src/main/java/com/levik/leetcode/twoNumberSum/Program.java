package com.levik.leetcode.twoNumberSum;

import java.util.HashSet;
import java.util.Set;

public class Program {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        Set<Integer> nums = new HashSet<>();
        for(int num : array) {
            int val = num - targetSum;

            if (nums.contains(val)) {
                return new int[] {val, num};
            } else {
                nums.add(val);
            }
        }

        return new int[0];
    }
}
