package com.levik.leetcode.findDuplicates;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //1,1,2
    //0,1,2

    //


    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int num : nums) {
            int index = Math.abs(num) - 1;

            if (nums[index] < 0) {
                result.add(Math.abs(index) + 1);
            }

            nums[index] = - nums[index];
        }

        return result;
    }
}
