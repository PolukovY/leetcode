package com.levik.leetcode.findMedianSortedArrays;

/**
 * 4. Median of Two Sorted Arrays
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = sort(nums1, nums2);
        return median(res);
    }

    private int[] sort(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        int[] res = new int[n + m];
        int k = 0;

        while (i < n && j <m) {
            int num1Val = nums1[i];
            int num2Val = nums2[j];

            if (num1Val < num2Val) {
                res[k] = num1Val;
                i++;
            } else {
                res[k] = num2Val;
                j++;
            }
            k++;
        }

        while (i < n) {
            res[k] = nums1[i];
            i++;
            k++;
        }

        while (j < m) {
            res[k] = nums2[j];
            j++;
            k++;
        }

        return res;
    }

    private static double median(int[] res) {
        int r = res.length;
        if(r % 2 == 1){
            int middle = (r - 1) / 2;
            return res[middle];
        }

        int idx1 = (r - 2) / 2;
        int idx2 = r / 2;
        return (res[idx1] + res[idx2]) / 2.0;
    }

}
