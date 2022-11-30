package com.levik.leetcode.missingNumber;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1() {
        int[] nums = new int[]{3,0,1};
        int expected = 2;

        int actual = new Solution().missingNumber(nums);

        assertThat(actual).isEqualTo(expected);
    }
}