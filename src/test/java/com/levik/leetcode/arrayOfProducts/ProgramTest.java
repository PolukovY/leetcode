package com.levik.leetcode.arrayOfProducts;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProgramTest {

    @Test
    void testCase1() {
        int[] input = {5, 1, 4, 2};
        int[] expected = {8, 40, 10, 20};

        int[] actual = new Program().arrayOfProducts(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int[] input = {1, 8, 6, 2, 4};
        int[] expected = {384, 48, 64, 192, 96};

        int[] actual = new Program().arrayOfProducts(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        int[] input = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expected = {362880, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        int[] actual = new Program().arrayOfProducts(input);

        assertThat(actual).isEqualTo(expected);
    }
}