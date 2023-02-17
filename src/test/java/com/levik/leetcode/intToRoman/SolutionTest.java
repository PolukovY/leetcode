package com.levik.leetcode.intToRoman;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {


    @Test
    void testCase1() {
        int num = 9;
        String expected = "IX";
        String actual = new Solution().intToRoman(num);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int num = 3;
        String expected = "III";
        String actual = new Solution().intToRoman(num);

        assertThat(actual).isEqualTo(expected);
    }
}