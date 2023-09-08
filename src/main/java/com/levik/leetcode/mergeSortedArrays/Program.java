package com.levik.leetcode.mergeSortedArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        List<Integer> first = null;
        List<Integer> second = null;

        for (List<Integer> array : arrays) {
            if (first == null) {
                first = array;
            } else if (second == null) {
                second = array;
            }

            if (first != null && second != null) {
                first = sortedArraysHelper(first, second);
                System.out.println(Arrays.toString(first.toArray()));
                second = null;
            }
        }

        return first;
    }

    private static List<Integer> sortedArraysHelper(List<Integer> first, List<Integer> second) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < first.size() && j < second.size()) {
            Integer firstVal = first.get(i);
            Integer secondVal = second.get(j);

            if (firstVal < secondVal) {
                result.add(firstVal);
                i++;
            } else if (firstVal > secondVal) {
                result.add(secondVal);
                j++;
            } else {
                result.add(firstVal);
                result.add(secondVal);
                i++;
                j++;
            }
        }

        while (i < first.size()) {
            Integer val = first.get(i);
            result.add(val);
            i++;
        }

        while (j < second.size()) {
            Integer val = second.get(j);
            result.add(val);
            j++;
        }

        return result;
    }
}
