package com.levik.leetcode.consistentHash;

import java.util.zip.CRC32;

public class CRC32Hash implements  HashFunction{
    @Override
    public long hash(String key) {
        CRC32 crc32 = new CRC32();
        crc32.update(key.getBytes());
        return crc32.getValue();
    }
}
