package com.levik.leetcode.randomizedSet;

import java.util.*;

public class RandomizedSet {

    private final Map<Integer, Integer> nums;
    public final List<Integer> values;

    public RandomizedSet() {
        this.nums = new HashMap<>();
        this.values = new ArrayList<>();

    }

    public boolean insert(int val) {
        if (nums.containsKey(val)) {
            return false;
        }

        int index = values.size();

        nums.put(val, index);
        values.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!nums.containsKey(val)) {
            return false;
        }

        Integer index = nums.get(val);
        int lastIndex = values.size() - 1;
        Integer lastValue = values.get(lastIndex);

        nums.put(lastValue, index);

        values.set(index, lastValue);
        values.remove(lastIndex);
        nums.remove(val);

        return true;
    }

    public int getRandom() {
        int size = values.size();
        int index = new Random().nextInt(size);
        return values.get(index);
    }
}
