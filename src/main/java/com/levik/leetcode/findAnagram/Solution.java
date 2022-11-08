package com.levik.leetcode.findAnagram;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final char FIRST_CHAR = 'a';

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return result;
        }

        int[] frequencyCounts = calcFrequencyCounts(p);

        solution(s, p, result, frequencyCounts);

        return result;
    }

    private static void solution(String s, String p, List<Integer> result, int[] frequencyCounts) {
        int left = 0;
        int right = 0;
        int count = p.length();

        while (right < s.length()) {
            int index = getIndex(s.charAt(right));
            int frequencyCount = frequencyCounts[index];

            if (frequencyCount >= 1) {
                count--;
            }

            if (count == 0) {
                result.add(left);
            }

            frequencyCounts[index] = --frequencyCount;
            right++;


            if (right - left == p.length()) {
                index = getIndex(s.charAt(left));
                frequencyCount = frequencyCounts[index];

                if (frequencyCount >= 0) {
                    count++;
                }

                frequencyCounts[index] = ++frequencyCount;
                left++;
            }
        }
    }

    private static int[] calcFrequencyCounts(String p) {
        int[] frequencyCounter = new int[26];

        for(char aChar: p.toCharArray()) {
            int index = getIndex(aChar);
            frequencyCounter[index]++;
        }

        return frequencyCounter;
    }

    private static int getIndex(char aChar) {
        return aChar - FIRST_CHAR;
    }

}
