package com.levik.leetcode.restoreString;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        var s = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
        var expected = "leetcode";

        String actual = new Solution().restoreString(s, indices);

        assertThat(actual).isEqualTo(expected);
    }
}