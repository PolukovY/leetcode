package com.levik.leetcode.peakIndexInMountainArray;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        int[] input = {0,10,5,2};
        int expectedIndex = 1;

        int actualIndex = new Solution().peakIndexInMountainArray(input);

        assertThat(actualIndex).isEqualTo(expectedIndex);
    }
}