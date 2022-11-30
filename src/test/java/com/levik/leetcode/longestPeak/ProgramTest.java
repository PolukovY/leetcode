package com.levik.leetcode.longestPeak;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProgramTest {

    @Test
    void testCase1() {
        var input = new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        var expected = 6;

        var actual = Program.longestPeak(input);

        assertThat(actual).isEqualTo(expected);
    }
}