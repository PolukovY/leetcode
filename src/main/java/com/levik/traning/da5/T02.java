package com.levik.traning.da5;

import java.util.Arrays;

public class T02 {

    /**
     * Вам дана матриця (сітка) MxN, заповнена невід'ємними цілими числами.
     * Знайдіть шлях з верхньої лівої (left top) клітини у праву нижню (bottom
     * right) з найменшою сумою чисел по дорозі.
     *
     * За умови, що можна рухатися ТІЛЬКИ вниз або вправо на будь-якому кроці.
     *
     * Приклад:
     * Input: grid = [
     * [1,3,1],
     * [1,5,1],
     * [4,2,1]
     * ]
     * Output: 7
     * Пояснення: шлях 1 → 3 → 1 → 1 → 1 має найменшу суму.
     *
     * [1,4,5],
     * [2,7,6],
     * [6,8,7]
     *
     * Обмеження:
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 200
     * 0 <= grid[i][j] <= 100
     */

    private static int solve(int[][] grid) {
        String a  = "aaa";
        char[] charArray = a.toCharArray();
        Arrays.sort(charArray);
        String sortedKey = Arrays.toString(charArray);

        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1] [0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0] [i - 1] + grid[0][i];
        }

        for (int  i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i -1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[n - 1][m -1];
    }

    public static void main(String[] args) {
        int[][] input = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(solve(input));
    }
}
