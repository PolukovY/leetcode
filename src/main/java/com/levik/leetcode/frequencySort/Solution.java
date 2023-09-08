package com.levik.leetcode.frequencySort;

import java.util.*;

import static java.lang.String.*;

public class Solution {

    public String frequencySort(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char aChar : s.toCharArray()) {
            frequency.put(aChar, frequency.getOrDefault(aChar, 0) + 1);
        }

        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> frequency.get(b) - frequency.get(a));
        queue.addAll(frequency.keySet());

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            Character aChar = queue.remove();
            Integer repeat = frequency.get(aChar);

            sb.append(valueOf(aChar).repeat(repeat));

        }


        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().frequencySort("tree");

    }
}
