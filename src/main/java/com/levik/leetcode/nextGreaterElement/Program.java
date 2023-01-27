package com.levik.leetcode.nextGreaterElement;

import java.util.Arrays;
import java.util.Stack;

public class Program {

    public int[] nextGreaterElement(int[] array) {
        int n = 2 * array.length;
        int[] res = new int[array.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int index = i % array.length;
            int val = array[index];

            while (!stack.isEmpty() && array[stack.peek()] < val) {
                int pop = stack.pop();
                res[pop] = val;
            }

            stack.push(index);
        }

        return res;
    }
}
