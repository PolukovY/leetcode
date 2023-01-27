package com.levik.leetcode.minRemoveToMakeValid;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class SolutionTest {

    @Test
    void testCase1() {
        var input = "lee(t(c)o)de)";
        var expected = "lee(t(c)o)de";

        String actual = new Solution().minRemoveToMakeValid(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        var input = "a)b(c)d";
        var expected = "ab(c)d";

        String actual = new Solution().minRemoveToMakeValid(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        var input = "))((";
        var expected = "";

        String actual = new Solution().minRemoveToMakeValid(input);

        assertThat(actual).isEqualTo(expected);
    }
}