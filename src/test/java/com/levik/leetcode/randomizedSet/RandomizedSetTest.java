package com.levik.leetcode.randomizedSet;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomizedSetTest {


    @Test
    void testCase1() {
        RandomizedSet randomizedSet = new RandomizedSet();

        boolean isRemoved = randomizedSet.remove(1);

        assertThat(isRemoved).isFalse();

        boolean isInserted = randomizedSet.insert(1);
        assertThat(isInserted).isTrue();

        isInserted = randomizedSet.insert(1);
        assertThat(isInserted).isFalse();

        isInserted = randomizedSet.insert(2);
        assertThat(isInserted).isTrue();
        isInserted = randomizedSet.insert(3);
        assertThat(isInserted).isTrue();

        isRemoved = randomizedSet.remove(2);
        assertThat(isRemoved).isTrue();

        int random = randomizedSet.getRandom();
        assertThat(random).isGreaterThan(0);
    }
}