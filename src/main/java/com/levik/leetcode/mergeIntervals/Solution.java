package com.levik.leetcode.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        
        List<int[]> results = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        int[] currentInterval = intervals[0];
        results.add(currentInterval);

        for (int[] interval : intervals) {
            int end_first = currentInterval[1];

            int start_second = interval[0];
            int end_second = interval[1];

            if (end_first >= start_second) {
                currentInterval[1] = Math.max(end_first, end_second);
            } else {
                currentInterval = interval;
                results.add(currentInterval);
            }
        }


        return results.toArray(new int[results.size()][]);
    }
}
