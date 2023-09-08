package com.levik.leetcode.reverseWords;

public class Solution {

    private static final String SPACE = " ";

    public String reverseWords(String s) {
        String [] words = s.split(SPACE);

        var build = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            var word = words[i];
            if (!"".equals(word)) {
                build.append(word).append(SPACE);
            }
        }

        String text = build.toString();

        if (text.endsWith(SPACE)) {
            return text.substring(0, text.lastIndexOf(SPACE));
        }

        return text;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("  hello world  "));
    }
}
