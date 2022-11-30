package com.levik.leetcode.checkValid;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean checkValid(int[][] matrix) {
        Set<Integer> numbers = new HashSet<>();
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                numbers.add(ints[j]);
            }

            if (numbers.size() != matrix.length) {
                return false;
            } else {
                numbers.clear();
            }
        }

        for(int i = 0 ; i < matrix.length; i ++){
            for (int[] ints : matrix) {
                numbers.add(ints[i]);
            }
            if (numbers.size() != matrix.length) {
                return false;
            } else {
                numbers.clear();
            }
        }

        return true;
    }
}
