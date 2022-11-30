package com.levik.leetcode.arrayOfProducts;

public class Program {

    public int[] arrayOfProducts(int[] array) {
        int[] result = new int[array.length];

        int prev = 1;
        for (int i = 0; i <= array.length - 1; i++) {
            result[i] = prev;
            prev *= array[i];
        }

        prev = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            result[i] *= prev;
            prev *= array[i];
        }

        return result;
    }
}
