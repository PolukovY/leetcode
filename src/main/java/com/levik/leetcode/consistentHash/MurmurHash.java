package com.levik.leetcode.consistentHash;

import java.nio.charset.StandardCharsets;

public class MurmurHash implements HashFunction {
    private final int seed;

    public MurmurHash(int seed) {
        this.seed = seed;
    }

    @Override
    public long hash(String key) {
        byte[] bytes = key.getBytes(StandardCharsets.UTF_8);
        int len = bytes.length;
        int m = 0x5bd1e995;
        int r = 24;
        int h = seed ^ len;
        int i = 0;
        while (len >= 4) {
            int k = bytes[i] & 0xff;
            k |= (bytes[i + 1] & 0xff) << 8;
            k |= (bytes[i + 2] & 0xff) << 16;
            k |= (bytes[i + 3] & 0xff) << 24;

            k *= m;
            k ^= k >>> r;
            k *= m;

            h *= m;
            h ^= k;

            i += 4;
            len -= 4;
        }
        switch (len) {
            case 3:
                h ^= (bytes[i + 2] & 0xff) << 16;
            case 2:
                h ^= (bytes[i + 1] & 0xff) << 8;
            case 1:
                h ^= bytes[i] & 0xff;
                h *= m;
        }
        h ^= h >>> 13;
        h *= m;
        h ^= h >>> 15;
        return (long) h & 0xffffffffL;
    }
}
