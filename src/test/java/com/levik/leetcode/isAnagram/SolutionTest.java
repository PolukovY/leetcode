package com.levik.leetcode.isAnagram;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        var s = "rat";
        var t = "car";
        boolean expected = false;

        boolean actual = new Solution().isAnagram(s, t);

        assertThat(actual).isEqualTo(expected);
    }
}