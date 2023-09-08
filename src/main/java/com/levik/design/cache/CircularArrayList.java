package com.levik.design.cache;

import java.util.*;
import java.util.stream.Collectors;

public class CircularArrayList<T extends TimeMarker> implements CircularList<T>{

    private static final String INDEX_OUT_OF_BOUND_MESSAGE = "IndexOutOfBounds: %s, size %s";
    private static final String DELIMITER = ",";

    private final int size;
    private final Object[] items;
    private final long expiredTimeMillis;
    private int index;

    public CircularArrayList(int initialCapacity, long expiredTimeMinutes) {
        this.items = new Object[initialCapacity];
        this.index = 0;
        this.size = initialCapacity;
        this.expiredTimeMillis = expiredTimeMinutes * 60 * 1000;
    }

    @Override
    public void set(int index, T item) {
        checkBoundaries(index);

        items[index] = item;
    }

    @Override
    public void add(T item) {
        resetIndexToStart();
        items[index] = item;
        index++;
    }

    @Override
    public Optional<T> get(int index) {
        checkBoundaries(index);

        T item = (T) items[index];

        return isNotItemExpired(item) ? Optional.of(item): Optional.empty();
    }

    private void checkBoundaries(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException(String.format(INDEX_OUT_OF_BOUND_MESSAGE, i, size));
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<T> getAll() {
        return Arrays.stream(items)
                .filter(Objects::nonNull)
                .map(it -> (T) it)
                .filter(this::isNotItemExpired)
                .sorted(Comparator.comparingLong(TimeMarker::getTimeMillis))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return getAll()
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(DELIMITER));
    }

    private void resetIndexToStart() {
        if (index == items.length) {
            index = 0;
        }
    }

    private boolean isNotItemExpired(T item) {
        return System.currentTimeMillis() - item.getTimeMillis() < expiredTimeMillis;
    }
}
