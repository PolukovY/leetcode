package com.levik.leetcode.containsNearbyDuplicate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1() {
        int[] nums = new int[] {1,2,3,1};
        int k = 3;
        boolean expected = true;

        boolean actual = new Solution().containsNearbyDuplicate(nums, k);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int[] nums = new int[] {1,0,1,1};
        int k = 1;
        boolean expected = true;

        boolean actual = new Solution().containsNearbyDuplicate(nums, k);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        int[] nums = new int[] {1,2,3,1,2,3};
        int k = 2;
        boolean expected = false;

        boolean actual = new Solution().containsNearbyDuplicate(nums, k);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase4() {
        int[] nums = new int[] {99, 99};
        int k = 2;
        boolean expected = true;

        boolean actual = new Solution().containsNearbyDuplicate(nums, k);

        assertThat(actual).isEqualTo(expected);
    }
}