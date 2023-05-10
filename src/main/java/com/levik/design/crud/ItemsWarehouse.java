package com.levik.design.crud;

import java.util.Optional;

public interface ItemsWarehouse<T, ID> {

    T add(T source);

    Optional<T> finaById(ID id);

    Page<T> findAll(Pageable pageable);

    void delete(ID id);
}


