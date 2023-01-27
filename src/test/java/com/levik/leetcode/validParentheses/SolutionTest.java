package com.levik.leetcode.validParentheses;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        String input = "()";
        boolean expected = true;

        boolean actual = new Solution().isValid(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        String input = "()[]{}";
        boolean expected = true;

        boolean actual = new Solution().isValid(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        String input = "(]";
        boolean expected = false;

        boolean actual = new Solution().isValid(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase4() {
        String input = ")";
        boolean expected = false;

        boolean actual = new Solution().isValid(input);

        assertThat(actual).isEqualTo(expected);
    }
}