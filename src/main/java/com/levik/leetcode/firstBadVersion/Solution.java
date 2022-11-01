package com.levik.leetcode.firstBadVersion;

public class Solution extends VersionControl {

    public int firstBadVersion(int n) {
        int bad = 0;
        int good = n;

        while (good - bad > 1){
            int m = (good + bad) >>> 1;

            boolean version = isBadVersion(m);
            if (version) {
                good = m;
            } else {
                bad = m;
            }
        }

        return good;
    }
}
