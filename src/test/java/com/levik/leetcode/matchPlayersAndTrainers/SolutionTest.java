package com.levik.leetcode.matchPlayersAndTrainers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        int[] players = {4,7,9};
        int[] trainers = {8,2,5,8};
        int expected = 2;

        int actual = new Solution().matchPlayersAndTrainers(players, trainers);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int[] players = {1,1,1};
        int[] trainers = {10};
        int expected = 1;

        int actual = new Solution().matchPlayersAndTrainers(players, trainers);

        assertThat(actual).isEqualTo(expected);
    }
}