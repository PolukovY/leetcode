package com.levik.leetcode.spiralTraverse;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static List<Integer> spiralTraverse(int[][] array) {
        int n = array.length - 1;
        int count = array.length / 2;

        if (array.length % 2 != 0) {
            count = array.length + 1;
        }

        int startIndex = 0;
        List<Integer> items = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            spiralHelper(array, startIndex + i, n, items);
        }

        //n - 4
        //spiralHelper(array, startIndex + 0, n, items);
        //spiralHelper(array, startIndex + 1, n, items);
        //n - 1


        return items;
    }

    private static void spiralHelper(int[][] array, int startIndex, int n, List<Integer> items) {
        System.out.println();
        int end = n - startIndex;
        for (int i = startIndex; i < end; i++) {
            items.add(array[startIndex][i]);
            System.out.print(array[startIndex][i] + " ");
        }
        System.out.println();
        for (int i = startIndex; i < end; i++) {
            items.add(array[i][end]);
            System.out.print(array[i][end] + " ");
        }
        System.out.println();
        for (int i = end; i > startIndex; i--) {
            items.add(array[end][i]);
            System.out.print(array[end][i] + " ");
        }
        System.out.println();
        for (int i = end; i > startIndex; i--) {
            items.add(array[i][startIndex]);
            System.out.print(array[i][startIndex] + " ");
        }
    }
}
