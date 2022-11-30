package com.levik.leetcode.intersect;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1() {
        var nums1 = new int[]{1,2,2,1};
        var nums2 = new int[]{2,2};
        var expected = new int[] {2, 2};

        int[] actual = new Solution().intersect(nums1, nums2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        var nums1 = new int[]{4,9,5};
        var nums2 = new int[]{9,4,9,8,4};
        var expected = new int[] {9, 4};

        int[] actual = new Solution().intersect(nums1, nums2);

        assertThat(actual).isEqualTo(expected);
    }
}