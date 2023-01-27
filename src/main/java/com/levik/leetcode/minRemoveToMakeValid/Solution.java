package com.levik.leetcode.minRemoveToMakeValid;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {

    public String minRemoveToMakeValid(String s) {
        char[] aChars = s.toCharArray();
        Stack<Integer> openParentheses = new Stack<>();
        Set<Integer> toRemove = new HashSet<>();

        for (int i = 0; i < aChars.length; i++) {
            char aChar = aChars[i];
            if (aChar == '(') {
                openParentheses.push(i);
            } else if (aChar == ')') {
                if (!openParentheses.isEmpty()) {
                    openParentheses.pop();
                } else {
                    toRemove.add(i);
                }
            }
        }

        while(!openParentheses.isEmpty()) {
            toRemove.add(openParentheses.pop());
        }

        var res = new StringBuilder();
        for (int i = 0; i < aChars.length; i++) {
            if (!toRemove.contains(i)) {
                res.append(aChars[i]);
            }
        }

        return res.toString();
    }
}
