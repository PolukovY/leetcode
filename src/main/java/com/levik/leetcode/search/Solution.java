package com.levik.leetcode.search;

import java.util.Arrays;

public class Solution {

    public int search(int[] nums, int target) {
        int left = -1;
        int right = nums.length - 1;

        System.out.println(Arrays.toString(nums));
        System.out.println("initial left:=" + left + " right:=" + right);
        System.out.println("------------------------------------------");

        int iteration = 0;
        while (right - left > 1) {
            int m = (right + left) / 2;
            int current = nums[m];
            System.out.println("Iteration-" + iteration++);
            System.out.println("m[" + m + "]:=" + m);
            if (current >= target) {
                right = m;
            } else {
                left = m;
            }

            System.out.println("left:=" + left + " right:=" + right + "\n");
        }
        int i = nums[right] == target ? right : -1;
        System.out.println("search index:=" + i);
        return i;
    }
}
