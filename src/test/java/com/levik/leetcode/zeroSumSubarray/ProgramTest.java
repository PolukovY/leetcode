package com.levik.leetcode.zeroSumSubarray;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProgramTest {

    @Test
    void testCase1() {
        var input = new int[] {4, 2, -1, -1, 3};
        var expected = true;
        var actual = new Program().zeroSumSubarray(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        var input = new int[] {};
        var expected = false;
        var actual = new Program().zeroSumSubarray(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        var input = new int[] {0};
        var expected = true;
        var actual = new Program().zeroSumSubarray(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase4() {
        var input = new int[] {1, 2, -2, 3};
        var expected = true;
        var actual = new Program().zeroSumSubarray(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase5() {
        var input = new int[] {2, 3, 4, -5, -3, 5, 5};
        var expected = false;
        var actual = new Program().zeroSumSubarray(input);
        assertThat(actual).isEqualTo(expected);
    }
}