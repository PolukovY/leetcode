package com.levik.leetcode.floodfill;

public class Solution {

    private static final int[][] STEP_FILL = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }

        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int i, int j, int color, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j] != color){
            return;
        }

        image[i][j] = newColor;

        for(int step = 0; step <= STEP_FILL.length; step++) {
            fill(image, i + STEP_FILL[step][0], j + STEP_FILL[step][1], color, newColor);
        }

        //fill(image, i + 1, j, color, newColor);
        //fill(image, i - 1, j, color, newColor);
        //fill(image, i, j + 1, color, newColor);
        //fill(image, i, j -1, color, newColor);
    }
}
