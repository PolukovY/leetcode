package com.levik.leetcode.smallerNumbersThanCurrent;

import java.util.Arrays;

public class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sortedNums = new int[nums.length];
        System.arraycopy(nums, 0, sortedNums, 0, nums.length);
        Arrays.sort(sortedNums);


        return new int[]{};

    }
}
