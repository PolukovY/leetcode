package com.levik.leetcode.findMaxAverage;

public class Solution {

    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = Integer.MIN_VALUE;
        double currentAvg = 0;
        double currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (i >= k - 1) {
                currentAvg = currentSum / k;
                maxAvg = Math.max(maxAvg, currentAvg);
                currentSum -= nums[i - (k - 1)];
            }
        }

        return maxAvg;

    }
}
