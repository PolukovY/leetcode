package com.levik.leetcode.minCostClimbingStairs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1() {
        int[] cost = {10,15,20};
        int expected = 15;

        int actual = new Solution().minCostClimbingStairs(cost);

        assertThat(actual).isEqualTo(expected);
    }
}