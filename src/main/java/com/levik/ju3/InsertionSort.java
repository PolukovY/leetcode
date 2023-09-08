package com.levik.ju3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertionSort {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(8, -2, 0, -1, 2, 7, -2));
        insertionSort(nums);
        nums.forEach(System.out::println);

        List<String> numsString = new ArrayList<>(List.of("aa", "bbb", "cc", "a", "b", "qq", "tt"));
        insertionSort(numsString);

        numsString.forEach(System.out::println);
    }

    public static <T extends Comparable<? super T>> void insertionSort(List<T> nums) {
        if (nums.size() <= 1) {
            return;
        }

        int i = 1;
        while (i < nums.size()) {
            T num = nums.get(i);
            int  j = i  - 1;

            while (j >= 0 && nums.get(j).compareTo(num) > 0) {
                nums.set(j + 1, nums.get(j));
                j--;
            }

            nums.set(j + 1, num);
            i++;
        }
    }

    public static void sort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int i = 1;
        while(i < nums.length) {
            int num = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > num) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = num;
            i++;
        }
    }

    /*public static void main(String[] args) {
        int[] nums = new int[] {8, -2, 0, -1, 2, 7, -2};
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }*/
}
