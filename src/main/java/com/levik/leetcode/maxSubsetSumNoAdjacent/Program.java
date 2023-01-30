package com.levik.leetcode.maxSubsetSumNoAdjacent;

public class Program {

    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        int[] max = array.clone();
        max[1] = Math.max(max[0], max[1]);

        for (int i = 2; i < max.length; i++) {
            max[i] = Math.max(max[i - 1], max[i - 2] + max[i]);
        }

        return max[max.length - 1];
    }
}
