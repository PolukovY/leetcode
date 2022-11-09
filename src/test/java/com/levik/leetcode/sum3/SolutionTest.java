package com.levik.leetcode.sum3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> lists = new Solution().threeSum(nums);

        assertThat(lists.size()).isEqualTo(2);
    }
}