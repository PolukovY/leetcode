package com.levik.leetcode.frequencytracker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrequencyTracker {

    private final Map<Integer, Integer> frequencyMap;
    private final Map<Integer, Set<Integer>> valueMap;

    public FrequencyTracker() {
        frequencyMap = new HashMap<>();
        valueMap = new HashMap<>();
    }

    public void add(int number) {
        int frequency = frequencyMap.getOrDefault(number, 0);
        frequencyMap.put(number, frequency + 1);

        if (!valueMap.containsKey(frequency + 1)) {
            valueMap.put(frequency + 1, new HashSet<>());
        }
        valueMap.get(frequency + 1).add(number);

        if (frequency > 0) {
            valueMap.get(frequency).remove(number);
            if (valueMap.get(frequency).isEmpty()) {
                valueMap.remove(frequency);
            }
        }
    }

    public void deleteOne(int number) {
        if (frequencyMap.containsKey(number)) {
            int frequency = frequencyMap.get(number);
            if (frequency == 1) {
                frequencyMap.remove(number);
            } else {
                frequencyMap.put(number, frequency - 1);
            }
            valueMap.get(frequency).remove(number);
            if (valueMap.get(frequency).isEmpty()) {
                valueMap.remove(frequency);
            }

            if (!valueMap.containsKey(frequency - 1)) {
                valueMap.put(frequency - 1, new HashSet<>());
            }
            valueMap.get(frequency - 1).add(number);
        }
    }

    public boolean hasFrequency(int frequency) {
        return valueMap.containsKey(frequency);
    }

    public static void main(String[] args) {
        FrequencyTracker tracker = new FrequencyTracker();
        tracker.add(5);
        tracker.add(7);
        tracker.add(5);
        tracker.add(2);
        tracker.add(7);

        System.out.println(tracker.hasFrequency(2)); // true
        System.out.println(tracker.hasFrequency(3)); // false

        tracker.deleteOne(5);
        tracker.deleteOne(2);

        System.out.println(tracker.hasFrequency(1)); // true
        System.out.println(tracker.hasFrequency(2)); // false
    }
}
