package com.levik.leetcode.firstUniqChar;

import java.util.Arrays;

public class Solution {

    private static final int MAX_CHARACTERS = 26;
    private static final char FIRST_LATTER = 'a';

    public int firstUniqChar(String s) {
        int[] counts = new int[MAX_CHARACTERS];
        int[] indices = new int[MAX_CHARACTERS];

        Arrays.fill(indices, -1);

        for (int i = 0; i < s.length(); i++) {
            char aChar = s.charAt(i);
            int index = index(aChar);

            if (indices[index] == -1) {
                indices[index] = i;
            }

            counts[index]++;
        }


        int minIndex = Integer.MAX_VALUE;

        for (int i = 0; i < MAX_CHARACTERS; i++) {
            int indicesVal = indices[i];
            if (counts[i] == 1 && indicesVal != -1 && indicesVal < minIndex) {
                minIndex = indicesVal;
            }
        }

        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }

    private int index(char aChar) {
        return aChar - FIRST_LATTER;
    }
}
