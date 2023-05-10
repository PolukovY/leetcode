package com.levik.leetcode.commonCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Program {

    public String[] commonCharacters(String[] strings) {
        Map<Character, Integer> map = new HashMap<>();

        for (String str : strings) {
            char[] chars = removeDuplicates(str.toCharArray());
            for (char aChar : chars) {
                map.put(aChar, map.getOrDefault(aChar, 0) + 1);
            }
        }

        return map.entrySet()
                .stream()
                .filter(it -> it.getValue().equals(strings.length))
                .map(t -> String.valueOf(t.getKey()))
                .toArray(String[]::new);
    }

    private char[] removeDuplicates(char[] chars) {
        Set<Character> set = new HashSet<>();
        for (char aChar :  chars) {
            if (!set.contains(aChar)) {
                set.add(aChar);
            }
        }

        return convert(set);

    }

    private char[] convert(Set<Character> source) {
        char[] items = new char[source.size()];
        int k = 0;

        for (Character s : source) {
            items[k] = s;
            k++;
        }

        return items;
    }
}
