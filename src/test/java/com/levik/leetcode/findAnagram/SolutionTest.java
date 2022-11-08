package com.levik.leetcode.findAnagram;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        var s = "cbaebabacd";
        var p = "abc";
        List<Integer> expected = Arrays.asList(0,6);

        List<Integer> actual = new Solution().findAnagrams(s, p);

        assertThat(actual).isEqualTo(expected);
    }
}