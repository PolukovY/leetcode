package com.levik.leetcode.nextGreaterElement;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProgramTest {

    @Test
    public void testCase1() {
        int[] input = new int[] {2, 5, -3, -4, 6, 7, 2};
        int[] expected = new int[] {5, 6, 6, 6, 7, -1, 5};

        int[] actual = new Program().nextGreaterElement(input);

        assertThat(actual).isEqualTo(expected);
    }

}