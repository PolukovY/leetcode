package com.levik.leetcode.searchMatrix;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1() {
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24}
        };
        int target = 20;
        boolean expected = false;

        boolean actual = new Solution().searchMatrix(matrix, target);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int[][] matrix = {
                {-5}
        };
        int target = -5;
        boolean expected = true;

        boolean actual = new Solution().searchMatrix(matrix, target);

        assertThat(actual).isEqualTo(expected);
    }
}