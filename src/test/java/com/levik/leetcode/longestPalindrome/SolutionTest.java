package com.levik.leetcode.longestPalindrome;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void testCase1() {
        var input = "babad";

        var actual = new Solution().longestPalindrome(input);

        assertThat(actual).isEqualTo("aba");
    }

    @Test
    public void testCase2() {
        var input = "cbbd";

        var actual = new Solution().longestPalindrome(input);

        assertThat(actual).isEqualTo("bb");
    }


}