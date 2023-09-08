package com.levik.ju3;

import java.util.concurrent.ThreadLocalRandom;

public class ArrayUtils {

    public static int[] generateArrays(int n) {
        int[] arrays = new int[n];

        for (int i = 0; i <= arrays.length - 1; i++) {
            arrays[i] = ThreadLocalRandom.current().nextInt();
        }

        return arrays;
    }
}
