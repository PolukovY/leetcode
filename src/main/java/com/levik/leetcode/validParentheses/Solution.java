package com.levik.leetcode.validParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Character> dictionary = new HashMap<>();
        dictionary.put(')', '(');
        dictionary.put('}', '{');
        dictionary.put(']', '[');

        Stack<Character> stack = new Stack<>();
        boolean isResult = true;

        for (char aChar : chars) {
            if (dictionary.containsKey(aChar)) {
                Character prevCharacter = dictionary.get(aChar);

                if (stack.isEmpty()) {
                    isResult = false;
                    break;
                }

                Character pop = stack.pop();
                if (!prevCharacter.equals(pop)) {
                    isResult = false;
                    break;
                }

            } else {
                stack.push(aChar);
            }
        }

        return stack.isEmpty() && isResult;
    }
}
