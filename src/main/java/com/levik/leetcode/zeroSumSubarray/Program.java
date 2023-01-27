package com.levik.leetcode.zeroSumSubarray;

import java.util.HashSet;
import java.util.Set;

public class Program {

    public boolean zeroSumSubarray(int[] nums) {
        Set<Integer> subArray = new HashSet<>();
        subArray.add(0);
        int sum = 0;

        for (int num : nums) {
            sum += num;

            if (subArray.contains(sum)) {
                return true;
            }

            subArray.add(sum);
        }

        return false;
    }
}
