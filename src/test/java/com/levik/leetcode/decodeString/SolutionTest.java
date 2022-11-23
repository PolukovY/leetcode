package com.levik.leetcode.decodeString;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1() {
        String s = "3[a]2[bc]";
        String expected = "aaabcbc";

        String actual = new Solution().decodeString(s);

        assertThat(actual).isEqualTo(expected);
    }
}