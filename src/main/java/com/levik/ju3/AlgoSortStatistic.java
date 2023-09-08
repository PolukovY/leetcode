package com.levik.ju3;

public class AlgoSortStatistic {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 2; i <= 1_000_000; i*=2) {
            int totalTime = 0;
            int repeats = 10;

            for (int j = 0; j <= repeats; j++) {
                int[] arrays = ArrayUtils.generateArrays(i);
                long startTime = System.nanoTime();
                AlgoSort.mergeSort(arrays);
                sum += arrays.length;
                long executionTime = System.nanoTime() - startTime;
                totalTime += executionTime;
            }

            int averageExecutionTime = totalTime /repeats;
            System.out.println(i + " " + averageExecutionTime);
        }

        System.out.println("Sum " + sum);
    }
}
