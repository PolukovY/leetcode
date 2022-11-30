package com.levik.leetcode.longestPeak;

public class Program {

    public static int longestPeak(int[] array) {
        int longestPeak = 0;
        int i = 1;

        while(i < array.length - 1) {
            boolean isPeak = array[i - 1] < array[i] && array[i] > array[i + 1];

            if (!isPeak) {
               i++;
               continue;
            }

            int leftIdx = i + 2;
            while (leftIdx >=0 && array[leftIdx] < array[leftIdx + 1]) {
                leftIdx--;
            }

            int rightIdx = i + 2;

            while (rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
                rightIdx++;
            }

            int currentPeak = rightIdx - leftIdx - 1;
            if (currentPeak > longestPeak) {
                longestPeak = currentPeak;
            }
            i  = rightIdx;
        }

        return longestPeak;
    }
}
