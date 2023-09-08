package com.levik.traning.day4;

import java.util.Arrays;

public class T01 {

    /**
     * Дано масив цілих чисел nums,
     * поверніть True якщо будь-яке число зустрічається в масиві хоча б 2 рази,
     * інакше поверніть False.
     * Рішення не має використовувати додаткову памʼять,
     * тобто, має бути О(1) по памʼяті.
     *
     * Приклад:
     * Input: nums = [1,2,3,1]
     * Output: true
     */
    private boolean solve(int[] nums) {
        Arrays.sort(nums); //1,1,2,3

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
        
    }
}
