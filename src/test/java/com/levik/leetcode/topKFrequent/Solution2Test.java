package com.levik.leetcode.topKFrequent;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Solution2Test {

    @Test
    void testCase1() {
        int[] expected = new int[]{1, 2};
        int[] actual = new Solution2().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int[] expected = new int[]{-1};
        int[] actual = new Solution2().topKFrequent(new int[]{-1, -1}, 1);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        int[] expected = new int[]{1, 2};
        int[] actual = new Solution2().topKFrequent(new int[]{1, 2}, 2);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase4() {
        int[] expected = new int[]{-1, -1};
        int[] actual = new Solution2().topKFrequent(new int[]{-1}, 1);
        assertThat(actual).isEqualTo(expected);
    }
}