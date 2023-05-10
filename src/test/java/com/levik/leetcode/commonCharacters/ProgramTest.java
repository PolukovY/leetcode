package com.levik.leetcode.commonCharacters;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ProgramTest {

    @Test
    void testCase1() {
        String[] input = new String[]{"abc", "bcd", "cbad"};
        String[] expected = new String[] {"b", "c"};

        String[] actual = new Program().commonCharacters(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        String[] input = new String[]{"a"};
        String[] expected = new String[] {};

        String[] actual = new Program().commonCharacters(input);

        assertThat(actual).isEqualTo(expected);
    }
}