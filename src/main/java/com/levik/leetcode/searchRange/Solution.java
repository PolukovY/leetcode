package com.levik.leetcode.searchRange;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int l = binarySearchHelper(nums, target, true);
        int r = binarySearchHelper(nums, target, false);

        return new int[] {l, r};
    }


    private int binarySearchHelper(int[] nums, int target, boolean isLeft) {
        int l = 0;
        int r  = nums.length - 1;

        int i = -1;

        while (l <= r) {
            int m  = (l + r) >> 1;

            if (target < nums[m]) {
                r = m - 1;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                i = m;

                if (isLeft) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }

        return i;
    }


}
