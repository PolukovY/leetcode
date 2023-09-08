package com.levik.ju3;

import java.util.Arrays;

public class AlgoSort {
    public static void bubbleSort(int[] arrays) {
        if (arrays.length <= 1) {
            return;
        }

        boolean swapped;
        for (int i  = 0; i <= arrays.length -1; i++) {
            int first = arrays[i];
            swapped = false;
            for (int j = i + 1; j <= arrays.length - 1; j++) {
                if (first > arrays[j]) {
                    swap(arrays, i, j);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    private static void swap(int[] arrays, int i, int j) {
        int tmp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = tmp;
    }

    public static void insertionSort(int[] arrays) {
        if (arrays.length <= 1) {
            return;
        }

        int i = 1;
        while (i < arrays.length) {
            int current = arrays[i];
            int j = i - 1;

            while (j >= 0 && arrays[j] > current) {
                arrays[j + 1] = arrays[j];
                j--;
            }

            arrays[j + 1] = current;
            i++;
        }
    }

    public static void mergeSort(int[] arrays) {
        int n = arrays.length;

        if (n <= 1) {
            return;
        }

        int mid = n / 2;
        int[] left = Arrays.copyOfRange(arrays, 0, mid);
        int[] right = Arrays.copyOfRange(arrays, left.length, n);

        mergeSort(left);
        mergeSort(right);

        merge(arrays, left, right);
    }

    public static void merge(int[] arrays, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arrays[k] = left[i];
                i++;
            } else {
                arrays[k] = right[j];
                j++;
            }

            k++;
        }

        while (i < left.length) {
            arrays[k++] = left[i++];
        }

        while (j < right.length) {
            arrays[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] arrays = {0, -2, 4, -3, 10, 12, 8, 1};
        System.out.println(Arrays.toString(arrays));
        //bubbleSort(arrays);
        //insertionSort(arrays);
        mergeSort(arrays);
        System.out.println(Arrays.toString(arrays));
    }


}
