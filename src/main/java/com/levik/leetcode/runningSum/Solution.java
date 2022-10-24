package com.levik.leetcode.runningSum;

public class Solution {

    public int[] runningSum(int[] nums) {
        int i = 0;
        int n = nums.length;
        int[] res = new int[n];
        int k = 1;
        res[0] = nums[0];

        for (int j = 1; j < n; j++) {
            res[k] = res[i] + nums[j];
            k++;
            i++;
        }

        return res;
    }
}
