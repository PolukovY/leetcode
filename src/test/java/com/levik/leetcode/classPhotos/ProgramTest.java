package com.levik.leetcode.classPhotos;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    @Test
    void testCase1() {
        List<Integer> redShirtHeights = new ArrayList<>(Arrays.asList(5, 8, 1, 3, 4));
        List<Integer> blueShirtHeights = new ArrayList<>(Arrays.asList(6, 9, 2, 4, 5));
        boolean expected = true;

        boolean actual = new Program().classPhotos(redShirtHeights, blueShirtHeights);

        assertThat(actual).isEqualTo(expected);
    }
}