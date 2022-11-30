package com.levik.leetcode.findTheDistanceValue;

import java.util.Arrays;

public class Solution {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;

        for (int num : arr1) {
            if (isValidDistance(arr2, num, d)) {
                count++;
            }
        }

        return count;
    }

    private boolean isValidDistance(int [] arr, int num, int d) {
        int low = -1;
        int high = arr.length;

        while (high - low > 1) {
            int m = high + (low - high) / 2;
            int val = arr[m];
            int dif = Math.abs(num - val);

            if (dif <= d) {
                return false;
            } else if (val > num) {
                high = m;
            } else {
                 low = m;
            }
        }

        return true;
    }
}
