package com.levik.leetcode.firstBadVersion;

public class VersionControl {

    public boolean isBadVersion(int m) {
        return switch (m) {
            case 5, 4 -> true;
            default -> false;
        };

    }
}
