package com.levik.leetcode.findKthLargest;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            queue.add(num);
        }

        int i = 1;
        int last = -1;

        while(i <= k) {
            last = queue.remove();
            i++;
        }

        return last;
    }
}
