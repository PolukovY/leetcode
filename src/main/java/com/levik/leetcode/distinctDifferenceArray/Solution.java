package com.levik.leetcode.distinctDifferenceArray;

import java.util.HashSet;

public class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        var prefix = new HashSet<>(n);
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            var suffix = new HashSet<>(n);

            prefix.add(nums[i]);
            int prefixCount = prefix.size();

            for (int j = i + 1; j < n; j++) {
                suffix.add(nums[j]);
            }

            int suffixCount = suffix.size();
            diff[i] = prefixCount - suffixCount;
        }

        return diff;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] diff = new Solution().distinctDifferenceArray(nums);

        for (int j : diff) {
            System.out.print(j + " ");
        }
    }
}
