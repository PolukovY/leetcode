package com.levik.leetcode.isIsomorphic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        var s = "egg";
        var t = "add";
        boolean expected = true;

        boolean actual = new Solution().isIsomorphic(s, t);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        var s = "foo";
        var t = "bar";
        boolean expected = false;

        boolean actual = new Solution().isIsomorphic(s, t);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        var s = "paper";
        var t = "title";
        boolean expected = true;

        boolean actual = new Solution().isIsomorphic(s, t);

        assertThat(actual).isEqualTo(expected);
    }
}