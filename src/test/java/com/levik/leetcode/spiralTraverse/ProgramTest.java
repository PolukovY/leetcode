package com.levik.leetcode.spiralTraverse;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ProgramTest {


    @Test
    void testCase1() {
        int[][] input = new int[][] {
                        {1, 2, 3, 4},
                        {12, 13, 14, 5},
                        {11, 16, 15, 6},
                        {10, 9, 8, 7},
                };
        var expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);

        var actual = Program.spiralTraverse(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int[][] input = new int[][] {
                {1, 2},
                {4, 3}
        };
        var expected = Arrays.asList(1,2, 3, 4);

        var actual = Program.spiralTraverse(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        int[][] input = new int[][] {
                {1, 2, 3},
                {6, 5, 4}
        };
        var expected = Arrays.asList(1,2, 3, 4, 5, 6);

        var actual = Program.spiralTraverse(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase4() {
        int[][] input = new int[][] {
                {1}
        };
        var expected = Arrays.asList(1);

        var actual = Program.spiralTraverse(input);

        assertThat(actual).isEqualTo(expected);
    }
}