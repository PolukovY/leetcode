package com.levik.leetcode.findTheDifference;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        var s = "abcd";
        var t = "abcde";
        char expected = 'e';

        char actual = new Solution().findTheDifference(s, t);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        var s = "ae";
        var t = "aea";
        char expected = 'a';

        char actual = new Solution().findTheDifference(s, t);

        assertThat(actual).isEqualTo(expected);
    }
}