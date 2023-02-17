package com.levik.leetcode.minNumberOfJumps;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    @Test
    void testCase1() {
        int[] input = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        int expected = 4;

        int actual = Program.minNumberOfJumps(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {

        int[] input = {1};
        int expected = 0;

        int actual = Program.minNumberOfJumps(input);
        assertThat(actual).isEqualTo(expected);
    }
}