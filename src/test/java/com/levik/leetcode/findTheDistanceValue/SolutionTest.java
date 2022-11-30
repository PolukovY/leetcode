package com.levik.leetcode.findTheDistanceValue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1() {
        int[] arr1 = {4,5,8};
        int[] arr2 = {10,9,1,8};
        int d = 2;
        int expected = 2;

        int actual = new Solution().findTheDistanceValue(arr1, arr2, d);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int[] arr1 = {-3,10,2,8,0,10};
        int[] arr2 = {-9,-1,-4,-9,-8};
        int d = 9;
        int expected = 2;

        int actual = new Solution().findTheDistanceValue(arr1, arr2, d);

        assertThat(actual).isEqualTo(expected);
    }
}