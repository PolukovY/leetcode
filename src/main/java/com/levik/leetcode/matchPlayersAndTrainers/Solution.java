package com.levik.leetcode.matchPlayersAndTrainers;

import java.util.Arrays;

public class Solution {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int matchedPlayerCount = 0;
        int p1 = 0;
        int p2 = 0;

        while (p1 < players.length && p2 < trainers.length) {
            if (players[p1] <= trainers[p2]) {
                matchedPlayerCount++;
                p1++;
            }

            p2++;
        }

        return matchedPlayerCount;
    }
}
