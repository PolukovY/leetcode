package com.levik.leetcode.deleteGreatestValue;

import java.util.Arrays;

public class Solution {

    public int deleteGreatestValue(int[][] grid) {
        for(int[] item : grid) {
            Arrays.sort(item);
        }

        int ans = 0;
        for(int i = grid[0].length - 1; i >= 0; i--) {
            int current = -1;
            for (int[] item : grid) {
                current = Math.max(current, item[i]);
            }
            ans += current;
        }

        return ans;
    }

}
