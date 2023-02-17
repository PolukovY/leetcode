package com.levik.leetcode.minNumberOfJumps;

import java.util.Arrays;

public class Program {

    public static int minNumberOfJumps(int[] array) {
       int[] dp  = new int[array.length];
       Arrays.fill(dp, Integer.MAX_VALUE);
       dp[0] = 0;

       for (int i = 0; i < array.length; i++) {
           for (int j = 0; j < i; j++) {
                if (array[j] >= i - j) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }

        return dp[dp.length - 1];
    }
}
