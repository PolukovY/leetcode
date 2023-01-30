package com.levik.leetcode.matchPlayersAndTrainers;

import java.util.Arrays;

public class Solution {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int trainerIndex = 0;
        int matchedPlayerCount = 0;

        for (int player : players) {
            while (trainerIndex < trainers.length) {
                int trainer = trainers[trainerIndex];
                trainerIndex++;

                if (trainer >= player) {
                    matchedPlayerCount++;
                    break;
                }
            }
        }

        return matchedPlayerCount;
    }
}
