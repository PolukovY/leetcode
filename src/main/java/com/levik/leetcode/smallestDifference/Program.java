package com.levik.leetcode.smallestDifference;

import java.util.Arrays;

public class Program {

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        int i = 0;
        int j = 0;
        int valI = 0;
        int valJ = 0;
        int dif = Integer.MAX_VALUE;

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        while(i < arrayOne.length && j < arrayTwo.length) {
            int valOne = arrayOne[i];
            int valTwo = arrayTwo[j];

            int currentDif = Math.abs(valOne - valTwo);
            dif = Math.min(currentDif, dif);

            if (currentDif == dif) {
                valI = arrayOne[i];
                valJ = arrayTwo[j];
            }

            if (valOne == valTwo) {
                break;
            } else if (valOne < valTwo) {
                i++;
            } else {
                j++;
            }
        }

        return new int[] {valI, valJ};
    }
}
