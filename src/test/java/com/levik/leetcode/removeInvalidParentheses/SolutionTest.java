package com.levik.leetcode.removeInvalidParentheses;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        var input = "()())()";
        var correctInput = "()()()()";
        List<String> expected = Arrays.asList(input, correctInput);

        List<String> actual = new Solution().removeInvalidParentheses(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        var input = "(a)())()";
        var correctInput = "(a)()()";
        List<String> expected = Arrays.asList(input, correctInput);

        List<String> actual = new Solution().removeInvalidParentheses(input);

        assertThat(actual).isEqualTo(expected);
    }
}