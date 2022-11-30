package com.levik.leetcode.countNegatives;

public class Solution {
    //solution 1
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i <= grid.length - 1;i++) {
            for(int j = grid[i].length - 1; j >= 0 ; j--) {
                if (grid[i][j] >= 0) {
                    break;
                } else {
                    count++;
                }
            }
        }

        return count;
    }

    public int countNegatives2(int[][] grid) {
        int count = 0;
        for (int i = 0; i <= grid.length - 1;i++) {
            count += findAllNegativeNumbers(i, grid[i]);
        }

        return count;
    }

    private int findAllNegativeNumbers(int i, int[] grid) {
        int bad = -1;
        int good = grid.length;

        while (good - bad > 1) {
            int m = good + (bad - good) / 2;
            int val = grid[m];

            if (val >= 0) {
                bad = m;
            } else {
                good = m;
            }
        }

        return grid.length - good;
    }
}
