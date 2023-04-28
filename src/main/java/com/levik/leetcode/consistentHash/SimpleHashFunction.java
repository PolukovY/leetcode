package com.levik.leetcode.consistentHash;

public class SimpleHashFunction implements HashFunction{
    @Override
    public long hash(String key) {
        return key.hashCode();
    }
}
