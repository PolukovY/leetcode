package com.levik.leetcode.missingNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int missingNumber(int[] nums) {
        Set<Integer> existingNumbers = new HashSet<>();
        int missingNumber = -1;

        for (int num : nums) {
            existingNumbers.add(num);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!existingNumbers.contains(i)) {
                missingNumber = i;
                break;
            }
        }

        return missingNumber;
    }
}
