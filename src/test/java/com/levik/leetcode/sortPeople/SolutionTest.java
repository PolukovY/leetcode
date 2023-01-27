package com.levik.leetcode.sortPeople;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        var names = new String[]{"Mary","John","Emma"};
        var heights = new int[] {180,165,170};
        String[] expected = new String[]{"Mary","Emma","John"};

        String[] actual = new Solution().sortPeople(names, heights);

        assertThat(actual).isEqualTo(expected);
    }
}