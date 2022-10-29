package com.levik.leetcode.mostWordsFound;

public class Solution {

    public static final String SPACE = " ";

    public int mostWordsFound(String[] sentences) {
        int maxNumberOfWords = 0;

        for (var sentence : sentences) {
            String[] words = sentence.split(SPACE);
            maxNumberOfWords = Math.max(maxNumberOfWords, words.length);
        }

        return maxNumberOfWords;
    }
}
