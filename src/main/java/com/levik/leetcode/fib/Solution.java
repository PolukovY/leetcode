package com.levik.leetcode.fib;

public class Solution {

    //Time Complexity: O(n) Extra Space: O(1)
    //Time Complexity: O(2^n) Extra Space: O(n)
    /*
                         fib(5)
                     /                \
               fib(4)                fib(3)
             /        \              /       \
         fib(3)      fib(2)         fib(2)   fib(1)
        /    \       /    \        /      \
  fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
  /     \
fib(1) fib(0)
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        //return fib(n - 1) + fib(n - 2);

        int firstItem = 0;
        int secondItem = 1;
        int nextItem;

        for (int i = 2; i <= n; i++) {
            nextItem = firstItem + secondItem;

            firstItem = secondItem;
            secondItem = nextItem;
        }

        return secondItem;
    }
}
