package com.levik.leetcode.mergeSortedArrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ProgramTest {

    @Test
    void testCase1() {
        List<List<Integer>> items = new ArrayList<>();
        items.add(Arrays.asList(1, 5, 9, 21));
        items.add(Arrays.asList(-1, 0));
        items.add(Arrays.asList(-124, 81, 121));
        items.add(Arrays.asList(3, 6, 12, 20, 150));

        List<Integer> result = Program.mergeSortedArrays(items);

        assertThat(result).isNotEmpty();

    }
}