package com.levik.leetcode.maxSubArray;

public class Solution {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum += num;
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }
}
