package com.levik.leetcode.lastStoneWeight;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    private static final int EMPTY = 0;

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int x = maxHeap.remove();
            int y = maxHeap.remove();

            if (x != y) {
                int newStone = x - y;
                maxHeap.add(newStone);
            }

        }

        return maxHeap.isEmpty() ? EMPTY : maxHeap.remove();
    }
}
