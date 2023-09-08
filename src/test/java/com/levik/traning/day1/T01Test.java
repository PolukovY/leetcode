package com.levik.traning.day1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class T01Test {

    @Test
    void testCase1() {
        int[] input = new int[] { 1, 2, 3, 4, 5 };
        int[] expected = new int[] { 1, 3, 6, 10, 15 };

        int[] actual = T01.solve(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int[] input = new int[] { 1, 1, 1, 1 };
        int[] expected = new int[] { 1, 2, 3, 4 };

        int[] actual = T01.solve(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        int[] input = new int[] { 1, 2, 3, 4, 6 };
        int[] expected = new int[] { 1, 3, 6, 10, 16 };

        int[] actual = T01.solve(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase4() {
        int[] input = new int[] { 1, 2, -3, 4, 6 };
        int[] expected = new int[] {1, 3, 0, 4, 10 };

        int[] actual = T01.solve(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase5() {
        int[] input = new int[] { -1, -1, -2, 4, 0 };
        int[] expected = new int[] { -1, -2, -4, 0, 0 };

        int[] actual = T01.solve(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase6() {
        int[] input = new int[] {  };
        int[] expected = new int[] {  };

        int[] actual = T01.solve(input);

        assertThat(actual).isEqualTo(expected);
    }
}