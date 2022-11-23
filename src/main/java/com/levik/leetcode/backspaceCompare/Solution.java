package com.levik.leetcode.backspaceCompare;

import java.util.Stack;

public class Solution {

    public boolean backspaceCompare(String s, String t) {
        return backspaceHelper(s).equals(backspaceHelper(t));
    }

    private Stack<Character> backspaceHelper(String text) {
        Stack<Character> stack = new Stack<>();

        for (char aChar : text.toCharArray()) {
            if (aChar != '#') {
                stack.push(aChar);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        return stack;
    }
}
