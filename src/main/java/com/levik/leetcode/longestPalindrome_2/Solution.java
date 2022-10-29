package com.levik.leetcode.longestPalindrome_2;

public class Solution {

    public int longestPalindrome(String s) {
        int[] counts = new int[128];
        int max = 0;

        for (char aChar : s.toCharArray()) {
            int i = ++counts[aChar];

            if (i % 2 == 0) {
                max += i;
                counts[aChar] = 0;
            }
        }

        for(int count : counts) {
            if (count == 1) {
                max += 1;
                break;
            }
        }

        return max;
    }
}
