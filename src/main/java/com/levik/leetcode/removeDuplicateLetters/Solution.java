package com.levik.leetcode.removeDuplicateLetters;

import java.util.Stack;

public class Solution {

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        char[] chars = s.toCharArray();

        for (char c : chars) {
            count[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            count[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}
