package com.levik.leetcode.characterReplacement;

public class Solution {

    public int characterReplacement(String s, int k) {
        int[] charCounts = new int[26];

        int start = 0;
        int max = 0;

        int res = 0;

        for(int end = 0; end < s.length(); end++) {
            int currentCount = ++charCounts[index(s, end)];
            max = Math.max(max, currentCount);

            while (end - start - max + 1 > k) {
                charCounts[index(s, start)]--;
                start++;
            }

            res = Math.max(res, end - start + 1);
        }


        return res;
    }

    private int index(String source, int position) {
        return source.charAt(position) - 'A';
    }
}
