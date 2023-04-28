package com.levik.leetcode.closesTarget;

public class ClosesTarget {

    public static int closestTarget(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        int min = 0;
        int i = 0;
        int j = 0;

        while (left < right){
            int sumDiff  = array[left] + array[right];

            if (sumDiff < target) {
                min = sumDiff;
                i = left;
                j = right;
            }

            if (sumDiff > target) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println("i:= " + i + " j:= " + j);

        return min;
    }
}
