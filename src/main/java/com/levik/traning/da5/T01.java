package com.levik.traning.da5;

import java.util.Arrays;

public class T01 {

    /**
     * Вам дано масив цілих чисел nums, знайдіть підмасив (що містить як мінімум 1
     * число) який має найбільшу суму та поверніть суму.
     *
     * Підмасив - це безперервна частина масиву.
     * Наприклад, для масиву [1,2,3,4], масив [2,3] є підмасивом, але [2,4] не є,
     * тому що це не безперервна частина масиву.
     *
     * Приклад
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Пояснення: [4,-1,2,1] має найбільшу суму = 6.
     *
     * Обмеження:
     * 1 <= nums.length <= 10^5
     * -10^4 <= nums[i] <= 10^4
     */
    private static int solve(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{-8, -2}));

    }
}
