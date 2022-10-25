package com.levik.leetcode.pivotIndex;

public class Solution {

    //[1,7,3,6,5,6]
    public int pivotIndex(int[] nums) {
        if(nums.length == 0) {
            return - 1;
        }

        int sumLeft = 0;
        int sumRight = 0;
        boolean isResultFound = false;
        int i;

        for(int num : nums) {
            sumRight += num;
        }

        for(i = 0; i < nums.length; i ++) {
            sumRight -= nums[i];

            if(sumRight == sumLeft) {
                isResultFound = true;
                break;
            }

            sumLeft += nums[i];
        }

        return isResultFound ? i : -1;
    }
}
