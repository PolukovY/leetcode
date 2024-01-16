package com.levik.leetcode.calculate;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public int calculate(String s) {
        Queue<Integer> number = new ArrayDeque<>();
        Queue<Character> operation = new ArrayDeque<>();
        Set<Character> suppoertedOperation = Set.of('+', '-', '*', '/');

        char[] charArray = s.toCharArray();

        StringBuilder numberText = new StringBuilder();
        for (int i = charArray.length - 1; i >= 0; i--) {
            char character = charArray[i];

            if (Character.isDigit(character)) {
                numberText.append(character);
            } else if (suppoertedOperation.contains(character)) {
                String currentText = numberText.toString();
                if (!currentText.isBlank()) {
                    operation.add(character);

                    int val = Integer.parseInt(numberText.toString());
                    number.add(val);
                    numberText = new StringBuilder();
                }
            }

            if (i == 0) {
                String currentText = numberText.toString();
                if (!currentText.isBlank()) {
                    int val = Integer.parseInt(numberText.reverse().toString());
                    number.add(val);
                }
            }
        }


        return calculateResult(number, operation);
    }

    private static int calculateResult(Queue<Integer> number, Queue<Character> operation) {
        Integer result = null;
        while (!number.isEmpty()) {
            Integer num = number.poll();

            if (result != null && num != null) {
                var currentOperation = operation.poll();

                if (currentOperation != null) {
                    if ('*' == currentOperation) {
                        num *= result;
                    } else if ('+' == currentOperation) {
                        num += result;
                    } else if ('-' == currentOperation) {
                        num -= result;
                    } else if ('/' == currentOperation) {
                        num /= result;
                    }

                    result = num;
                }
            }

            if (result == null) {
                result = num;
            }

        }
        return result != null ? result : 0;
    }

    public static void main(String[] args) {
        int calculate = new Solution().calculate("3+2*2");
        System.out.println(calculate);
    }
}
