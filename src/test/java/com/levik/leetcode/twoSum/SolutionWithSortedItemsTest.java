package com.levik.leetcode.twoSum;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class SolutionWithSortedItemsTest {

    @Test
    void testCase1() {
        int[] input = {2,7,11,15};
        int target = 9;
        int[] expected = {1, 2};

        int[] actual = new SolutionWithSortedItems().twoSum(input, target);

        assertThat(actual).isEqualTo(expected);
    }
}