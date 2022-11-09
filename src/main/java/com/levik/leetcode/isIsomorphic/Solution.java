package com.levik.leetcode.isIsomorphic;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapSt = new HashMap<>();
        Map<Character, Character> mapTs = new HashMap<>();

        for(int i = 0; i< s.length(); i++) {
            char sVal = s.charAt(i);
            char tVal = t.charAt(i);

            if ((isKeyExistAndEqualsWith(mapSt, sVal, tVal) || isKeyExistAndEqualsWith(mapTs, tVal, sVal))) {
                return false;
            }

            mapSt.put(sVal, tVal);
            mapTs.put(tVal, sVal);
        }

        return true;
    }

    private boolean isKeyExistAndEqualsWith(Map<Character, Character> container, char key, char val) {
        return container.containsKey(key) && container.get(key) != val;
    }
}
