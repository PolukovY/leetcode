package com.levik.leetcode.searchRange;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1() {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] expected = new int[]{3,4};

        int[] actual = new Solution().searchRange(nums, target);

        assertThat(actual).isEqualTo(expected);
    }
}