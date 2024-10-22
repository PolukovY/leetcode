package com.levik.leetcode.dailyTemperatures;

import java.util.Stack;

public class Solution {

  /**
   * Daily Temperatures
   * You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith day.
   *
   * Return an array result where result[i] is the number of days after the ith day before a warmer temperature appears on a future day.
   * If there is no day in the future where a warmer temperature will appear for the ith day, set result[i] to 0 instead.
   *
   * Example 1:
   *
   * Input: temperatures = [30,38,30,36,35,40,28]
   *
   * Output: [1,4,1,2,1,0,0]
   * @param temperatures
   * @return
   */
  public int[] dailyTemperatures(int[] temperatures) {
    int[] res = new int[temperatures.length];
    Stack<int[]> stack = new Stack<>(); // pair: [temp, index]

    for (int i = 0; i < temperatures.length; i++) {
      int t = temperatures[i];
      while (!stack.isEmpty() && t > stack.peek()[0]) {
        int[] pair = stack.pop();
        res[pair[1]] = i - pair[1];
      }
      stack.push(new int[]{t, i});
    }
    return res;
  }
}
