package com.levik.design.cache;

import java.util.List;
import java.util.Optional;

public interface CircularList<T extends TimeMarker> {

    void set(int index, T item);

    void add(T item);

    Optional<T> get(int i);

    int size();

    List<T> getAll();
}
