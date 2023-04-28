package com.levik.leetcode.closesTarget;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ClosesTargetTest {

    @Test
    void testCase1() {
        int[] array = {1, 2, 4, 7, 10};
        int target  = 15;

        int expectedTarget = 14;

        int actualTarget = ClosesTarget.closestTarget(array, target);

        assertThat(actualTarget).isEqualTo(expectedTarget);
    }
}