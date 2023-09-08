package com.levik.traning.day1;


/**
 * Даний масив чисел nums.
 * Running sum для елемента 'i' заданий як сума елементів [0..i], тобто
 * runningSum[i] = nums[0] + nums[1] + .. + nums[i]
 * Обчисліть та поверніть масив running sum.
 *
 * Додаткові умови:
 * 1. Не змінюйте вхідний масив
 * 2. Старайтеся використати O(1) додаткової пам'яті (без урахування вихідного масиву)
 *
 * Приклад:
 * Input: nums = [1, 2, 3]
 * Output: [1, 3, 6], бо [1, 1+2, 1+2+3]
 */
public class T01 {

    //time - O(n), space - O(1)
    public static int[] solve(int[] nums) {
        if (nums.length == 0) {
            return new int[]{};
        }

        int[] sum = new int[nums.length];

        sum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        return sum;
    }
}
