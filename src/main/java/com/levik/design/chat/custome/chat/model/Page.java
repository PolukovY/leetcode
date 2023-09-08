package com.levik.design.chat.custome.chat.model;

import java.util.List;

record Page<T>(List<T> items, int totalSize, int pageSize, int pageNum, int start) {
}
