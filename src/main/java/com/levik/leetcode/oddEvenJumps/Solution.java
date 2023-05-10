package com.levik.leetcode.oddEvenJumps;

import java.util.*;

class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        boolean[] oddJumps = new boolean[n];
        boolean[] evenJumps = new boolean[n];

        oddJumps[n - 1] = true;
        evenJumps[n - 1] = true;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);

        int count = 1;

        for (int i = n - 2; i >= 0; i--) {
            int val = arr[i];
            Map.Entry<Integer, Integer> nextHigher = map.ceilingEntry(val);
            Map.Entry<Integer, Integer> nextLower = map.floorEntry(val);

            // If we can make an odd jump from this index, mark it as reachable
            if (nextHigher != null && evenJumps[nextHigher.getValue()]) {
                oddJumps[i] = true;
                count++;
            }

            // If we can make an even jump from this index, mark it as reachable
            if (nextLower != null && oddJumps[nextLower.getValue()]) {
                evenJumps[i] = true;
            }

            map.put(val, i);
        }

        return count;
    }
}

