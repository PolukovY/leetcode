package com.levik.leetcode.characterReplacement;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        String s = "AABABBA";
        int k = 1;
        int expected = 4;

        int actual = new Solution().characterReplacement(s, k);

        assertThat(actual).isEqualTo(expected);
    }
}