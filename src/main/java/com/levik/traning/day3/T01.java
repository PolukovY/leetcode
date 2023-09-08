package com.levik.traning.day3;


/**
 * Дано масив цілих унікальних чисел arr, відсортований за зростанням
 * Масив розміром N, для кожного елемента якого виконується 1 <= arr[i] <= N
 *
 * Один елемент видалили з масиву -- знайдіть відсутній елемент.
 *
 * Приклад:
 * input: arr = [1, 2, 3, 4, 5, 7]
 * output: 6
 */
public class T01 {

    private int solve(int[] arr) {
        int left = 0;
        int right = arr.length - 1; 

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == mid + 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left + 1;
    }

    public static void main(String[] args) {
        int solve = new T01().solve(new int[] { 1, 2, 3, 4, 5, 6 });
        System.out.println(solve);
    }
}
