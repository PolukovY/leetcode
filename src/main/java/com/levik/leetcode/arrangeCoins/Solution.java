package com.levik.leetcode.arrangeCoins;

public class Solution {

    public int arrangeCoins(int n) {
        int res = n;

        for (int i = 1; i <= n; i++) {
            res -= i;

            if (res < 0) {
                return i - 1;
            } else if (res == 0) {
                return i;
            }
        }

        return 0;
    }
}
