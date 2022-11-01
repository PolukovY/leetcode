package com.levik.leetcode.numIslands;

public class Solution {

    private static final char LAND = '1';
    private static final char WATER = '0';
    private static final int[][] DIRECTION = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
    };

    public int numIslands(char[][] grid) {
        if (isGridEmpty(grid)) {
            return 0;
        }

        return getNumberOfLands(grid);
    }

    private int getNumberOfLands(char[][] grid) {
        int numberOfLands = 0;

        for (int row = 0; row < grid.length; row++) {
            for(int cell = 0; cell < grid[row].length; cell++) {
                if (isLand(grid, row, cell)) {
                    numberOfLands += dfc(grid, row, cell);
                }
            }
        }
        return numberOfLands;
    }

    private static boolean isGridEmpty(char[][] grid) {
        return grid == null || grid.length == 0;
    }

    private int dfc(char[][] grid, int row, int cell) {
        if (isVisited(grid, row, cell)) {
            return 0;
        }

        grid[row][cell] = WATER;

        for (int[] direction : DIRECTION) {
            dfc(grid, row + direction[0], cell + direction[1]);
        }

        return 1;
    }

    private static boolean isVisited(char[][] grid, int row, int cell) {
        return row < 0 || row >= grid.length || cell < 0 || cell >= grid[row].length || grid[row][cell] == WATER;
    }

    private static boolean isLand(char[][] grid, int row, int cell) {
        return grid[row][cell] == LAND;
    }
}
