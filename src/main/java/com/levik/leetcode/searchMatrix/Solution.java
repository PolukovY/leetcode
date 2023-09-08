package com.levik.leetcode.searchMatrix;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean found = false;

        for (int [] row : matrix) {
            boolean itemFound = search(row, target);

            if (itemFound) {
                found = true;
                break;
            }
        }

        return found;

    }

    private boolean search(int[] row, int target) {
        int l = -1;
        int r = row.length;

        while (r - l > 1) {
            int m = l + (r - l) / 2;
            int val = row[m];

            if (val < target) {
                l = m;
            } else if (val > target) {
                r = m;
            } else {
                return true;
            }
        }
        return false;
    }
}
