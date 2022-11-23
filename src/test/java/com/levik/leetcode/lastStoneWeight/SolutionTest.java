package com.levik.leetcode.lastStoneWeight;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1() {
        var stones = new int[]{2,7,4,1,8,1};
        int expected = 1;

        int actual = new Solution().lastStoneWeight(stones);

        assertThat(actual).isEqualTo(expected);
    }
}