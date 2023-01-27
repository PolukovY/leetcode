package com.levik.leetcode.isAnagram;

import java.util.Arrays;

public class Solution {

    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        boolean result = false;

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        if (sChars.length == tChars.length) {
            int r = sChars.length - 1;
            while (r<= 0) {
                if (sChars[r] != tChars[r]) {
                    result = true;
                    break;
                }
                r--;
            }
        }

        return result;
    }
}
