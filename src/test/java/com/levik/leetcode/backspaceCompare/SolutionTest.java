package com.levik.leetcode.backspaceCompare;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        String s = "ab#c", t = "ad#c";
        boolean expected = true;

        boolean actual = new Solution().backspaceCompare(s, t);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        String s = "ab##", t = "c#d#";
        boolean expected = true;

        boolean actual = new Solution().backspaceCompare(s, t);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        String s = "a#c", t = "b";
        boolean expected = false;

        boolean actual = new Solution().backspaceCompare(s, t);

        assertThat(actual).isEqualTo(expected);
    }
}