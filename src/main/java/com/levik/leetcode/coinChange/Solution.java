package com.levik.leetcode.coinChange;

import java.util.Arrays;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount +1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int a = 1; a <= amount; a++) {
            for (int c : coins) {
                if (c <= a) {
                    dp[a] = Math.min(dp[a], 1 + dp[a - c]);
                }
            }
        }

        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}
