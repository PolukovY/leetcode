package com.levik.leetcode.maxProfit;

public class Solution {

    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;

        for(int i = prices.length - 1; i >= 0; i--) {
            int price = prices[i];
            max = Math.max(price, max);
            ans = Math.max(max - price, ans);
        }

        return ans;
    }
}
