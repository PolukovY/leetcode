package com.levik.leetcode.tandemBicycle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Program {

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);

        if (fastest) {
            Arrays.sort(blueShirtSpeeds);
            return tandemBicycleHelper(redShirtSpeeds, blueShirtSpeeds);
        }

        List<Integer> blueShirtSpeedItems = IntStream.of(blueShirtSpeeds)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        return tandemBicycleHelper(redShirtSpeeds, blueShirtSpeedItems);

    }

    private int tandemBicycleHelper(int[] redShirtSpeeds, List<Integer> blueShirtSpeedItems) {
        int total = 0;

        for (int i = 0; i < redShirtSpeeds.length; i++) {
            int firstRider = redShirtSpeeds[i];
            int secondRider = blueShirtSpeedItems.get(blueShirtSpeedItems.size() - i - 1);
            total += Math.max(firstRider, secondRider);
        }

        return total;
    }

    private int tandemBicycleHelper(int[] redShirtSpeeds, int[] blueShirtSpeeds) {
        int total = 0;

        for (int i = 0; i < redShirtSpeeds.length; i++) {
            int firstRider = redShirtSpeeds[i];
            int secondRider = blueShirtSpeeds[blueShirtSpeeds.length - i - 1];
            total += Math.max(firstRider, secondRider);
        }

        return total;
    }
}
