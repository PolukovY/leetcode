package com.levik.leetcode.validStartingCity;

public class Program {

    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int currentMiles = 0;

        int startIndex = 0;
        int milesFromStarting = 0;

        for (int idx = 1; idx < distances.length; idx++) {
            int prev = distances[idx - 1];
            int fuelPrev = fuel[idx - 1];

            currentMiles += fuelPrev * mpg - prev;

            if (currentMiles < milesFromStarting) {
                milesFromStarting = currentMiles;
                startIndex = idx;
            }
        }

        return startIndex;
    }
}
