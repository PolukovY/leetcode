package com.levik.leetcode.matchPlayersAndTrainers;

import java.util.Arrays;

public class Solution {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0;
        int count = 0;

        for (int player : players) {
            while (i < trainers.length) {
                int trainer = trainers[i];
                i++;

                if (trainer >= player) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
