package com.levik.leetcode.removeDuplicateLetters;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        var input = "bcabc";
        var expected = "abc";

        String actual = new Solution().removeDuplicateLetters(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        var input = "cbacdcbc";
        var expected = "acdb";

        String actual = new Solution().removeDuplicateLetters(input);

        assertThat(actual).isEqualTo(expected);
    }
}