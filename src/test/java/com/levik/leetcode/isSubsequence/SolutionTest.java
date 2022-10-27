package com.levik.leetcode.isSubsequence;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        var s = "abc";
        var t = "ahbgdc";
        boolean expected = true;

        boolean actual = new Solution().isSubsequence(s, t);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        var s = "axc";
        var t = "ahbgdc";
        boolean expected = false;

        boolean actual = new Solution().isSubsequence(s, t);

        assertThat(actual).isEqualTo(expected);
    }
}