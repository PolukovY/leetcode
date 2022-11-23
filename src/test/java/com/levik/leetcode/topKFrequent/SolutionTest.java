package com.levik.leetcode.topKFrequent;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1() {
        String[] words = new String[]{"i","love","leetcode","i","love","coding"};
        int k = 2;
        List<String> expected = Arrays.asList("i", "love");

        List<String> actual = new Solution().topKFrequent(words, k);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        String[] words = new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 4;
        List<String> expected = Arrays.asList("the","is","sunny","day");

        List<String> actual = new Solution().topKFrequent(words, k);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        String[] words = new String[]{"i","love","leetcode","i","love","coding"};
        int k = 3;
        List<String> expected = Arrays.asList("i","love","coding");

        List<String> actual = new Solution().topKFrequent(words, k);

        assertThat(actual).isEqualTo(expected);
    }
}