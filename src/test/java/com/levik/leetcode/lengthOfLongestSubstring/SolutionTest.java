package com.levik.leetcode.lengthOfLongestSubstring;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        var input = "abcabcbb";

        int actual = new Solution().lengthOfLongestSubstring(input);

        assertThat(actual).isEqualTo(3);
    }


    @Test
    void testCase2() {
        var input = "bbbbb";

        int actual = new Solution().lengthOfLongestSubstring(input);

        assertThat(actual).isEqualTo(1);
    }

    @Test
    void testCase3() {
        var input = "pwwkew";

        int actual = new Solution().lengthOfLongestSubstring(input);

        assertThat(actual).isEqualTo(3);
    }
}