package com.levik.leetcode.isIsomorphic;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapSt = new HashMap<>();
        Map<Character, Character> mapTs = new HashMap<>();

        int n = s.length();

        for(int i = 0; i<n; i++) {
            char sVal = s.charAt(i);
            char tVal = t.charAt(i);

            if ((mapSt.containsKey(sVal) && mapSt.get(sVal) != tVal) || (mapTs.containsKey(tVal) && mapTs.get(tVal) != sVal)) {
                return false;
            }

            mapSt.put(sVal, tVal);
            mapTs.put(tVal, sVal);
        }

        return true;
    }
}
