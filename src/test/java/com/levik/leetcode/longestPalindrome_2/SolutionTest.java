package com.levik.leetcode.longestPalindrome_2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        var s = "abccccdd";
        int expected = 7;

        int actual = new Solution().longestPalindrome(s);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        var s = "a";
        int expected = 1;

        int actual = new Solution().longestPalindrome(s);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        var s = "ccc";
        int expected = 3;

        int actual = new Solution().longestPalindrome(s);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase4() {
        var s = "aaaAaaaa";
        int expected = 7;

        int actual = new Solution().longestPalindrome(s);

        assertThat(actual).isEqualTo(expected);
    }
}