package com.levik.leetcode.intersect;

import java.util.*;

public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int l = 0;
        int r = 0;

        while (l <= nums1.length - 1 && r <= nums2.length - 1) {
            int numLeft = nums1[l];
            int numRight = nums2[r];

            if (numLeft == numRight) {
                result.add(numLeft);
                r++;
                l++;
            } else if (numLeft > numRight) {
                r++;
            } else {
                l++;
            }
        }

        return convertToMass(result);
    }

    private static int[] convertToMass(List<Integer> result) {
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
