package com.levik.leetcode.smallestDifference;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProgramTest {

    @Test
    void testCase1() {
        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};
        int[] expected = {28, 26};

        int[] actual = Program.smallestDifference(arrayOne, arrayTwo);

        assertThat(actual).isEqualTo(expected);
    }
}