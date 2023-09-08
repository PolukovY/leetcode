package com.levik.leetcode.semordnilap;

import java.util.*;

public class Program {

    public ArrayList<ArrayList<String>> semordnilap(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();
            if (set.contains(reverse) && !reverse.equals(word)) {
                result.add(new ArrayList<>(Arrays.asList(reverse, word)));
                set.removeAll(Arrays.asList(word, reverse));
            }
        }

        return result;
    }

    public static void main(String[] args) {

        var input = new String[] {"aaa", "bbbb"};
        ArrayList<ArrayList<String>> expected = new ArrayList<>();
        ArrayList<String> pair = new ArrayList<String>();
        pair.add("desserts");
        pair.add("stressed");
        expected.add(pair);
        var actual = new Program().semordnilap(input);


        expected.equals(actual);
    }
}
