package com.levik.leetcode.restoreString;

public class Solution {

    public String restoreString(String s, int[] indices) {
        char[] items = new char[s.length()];
        var text = new StringBuilder();

        char[] chars = s.toCharArray();
        int j = 0;

        for (int i : indices) {
            char aChar = chars[j];
            items[i] = aChar;
            j++;
        }

       for (char item : items) {
           text.append(item);
       }

       return text.toString();
    }
}
