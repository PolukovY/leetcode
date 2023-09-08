package com.levik.traning.day1;

public class T02 {


    //time O(n*m), space O(1)
    private int solve(int[][] accounts) {
        int maxSum = 0;

        for (int[] clientAccounts : accounts) {

            int currentSum = 0;
            for (int clientAccount : clientAccounts) {
                currentSum += clientAccount;
            }

            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }
}
