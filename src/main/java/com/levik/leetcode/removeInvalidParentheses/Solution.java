package com.levik.leetcode.removeInvalidParentheses;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<String> removeInvalidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder correctString = new StringBuilder();
        int[] openAndClose = calculateOpenAndCloseParentheses(s);
        int open = openAndClose[0];
        int close = openAndClose[1];

        for (char aChar : s.toCharArray()) {
            if (aChar == '(') {
                stack.push(aChar);
                correctString.append(aChar);
            } else if (aChar == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    correctString.append(aChar);
                }
            } else {
                correctString.append(aChar);
            }
        }

        return Arrays.asList(s, correctString.toString());
    }

    private int[] calculateOpenAndCloseParentheses(String s) {
        int open = 0;
        int close = 0;

        for (char aChar : s.toCharArray()) {
            if (aChar == '(') {
                open++;
            } else if (aChar == ')') {
                close++;
            }
        }

        return new int[] {open , close};
    }
}
