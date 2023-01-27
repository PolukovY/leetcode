package com.levik.leetcode.tandemBicycle;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProgramTest {

    @Test
    void testCase1() {
        int[] redShirtSpeeds = new int[] {5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = new int[] {3, 6, 7, 2, 1};
        boolean fastest = true;
        int expected = 32;

        var actual = new Program().tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest);

        assertThat(actual).isEqualTo(expected);
    }
}