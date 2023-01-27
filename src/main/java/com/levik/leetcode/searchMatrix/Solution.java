package com.levik.leetcode.searchMatrix;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;
        for (int[] row : matrix) {
            int lastVal = row[row.length - 1];
            if (lastVal == target) {
                result = true;
            } else if (lastVal > target) {
                result = binarySearch(row, target);
            }

            if (result) {
                break;
            }
        }

        return result;
    }

    private boolean binarySearch(int[] array, int target) {
        int left = -1;
        int right = array.length;

        while (right - left > 1) {
            int m  = left + (right - left) / 2;
            int val = array[m];

            if (val  == target) {
                return true;
            } else if (val > target) {
                right = m;
            } else {
                left = m;
            }
        }

        return false;
    }
}
