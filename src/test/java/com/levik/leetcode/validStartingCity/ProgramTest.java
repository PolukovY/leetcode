package com.levik.leetcode.validStartingCity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    @Test
    void testCase1() {
        int[] distances = new int[] {5, 25, 15, 10, 15};
        int[] fuel = new int[] {1, 2, 1, 0, 3};
        int mpg = 10;
        int expected = 4;

        var actual = new Program().validStartingCity(distances, fuel, mpg);

        assertThat(actual).isEqualTo(expected);
    }
}