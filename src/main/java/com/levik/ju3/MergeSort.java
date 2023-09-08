package com.levik.ju3;

import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static <T extends Comparable<? super T>> void mergeSort(List<T> nums) {
        int n = nums.size();

        if (n <= 1) {
            return;
        }

        int mid = n / 2;
        List<T> left = nums.subList(0, mid);
        List<T> right = nums.subList(mid, n);

        mergeSort(left);
        mergeSort(right);

        mergeHelper(nums, left, right);
    }

    private static <T extends Comparable<? super T>> void mergeHelper(List<T> nums, List<T> left, List<T> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            T leftVal = left.get(i);
            T rightVal = right.get(j);
            if (leftVal.compareTo(rightVal) <= 0) {
                nums.set(k, leftVal);
                i++;
            } else {
                nums.set(k, rightVal);
                j++;
            }
            k++;
        }

        while (i < left.size()) {
            nums.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            nums.set(k++, right.get(j++));
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(0, -2, 1, -9, 10, 2, 5);
        nums.forEach(System.out::println);
        mergeSort(nums);
        System.out.println();
        nums.forEach(System.out::println);
    }
}
