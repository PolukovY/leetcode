package com.levik.leetcode.isSubsequence;

public class Solution {

    public boolean isSubsequence(String s, String t) {
        int sPointer = 0;

        if (s.length() == 0) {
            return true;
        }

        for (int tPointer = 0; tPointer< t.length(); tPointer++) {
            if (t.charAt(tPointer) == s.charAt(sPointer)) {
                sPointer++;

                if (sPointer == s.length()) {
                    return true;
                }
            }
        }

        return false;
    }
}
