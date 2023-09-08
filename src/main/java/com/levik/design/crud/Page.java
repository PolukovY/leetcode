package com.levik.design.crud;

import java.util.List;

public record Page<T>(List<T> items, int totalSize, int pageSize, int pageNum, long start) {

}
