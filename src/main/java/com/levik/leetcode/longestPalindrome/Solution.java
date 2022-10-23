package com.levik.leetcode.longestPalindrome;

import java.util.Objects;
import java.util.stream.IntStream;

public class Solution {

    public String longestPalindrome(String s) {
        if (Objects.isNull(s) || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = middle(s, i, i);
            int len2 = middle(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }


        return s.substring(start, end + 1);
    }

    private int middle(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
