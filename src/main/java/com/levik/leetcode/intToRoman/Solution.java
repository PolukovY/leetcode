package com.levik.leetcode.intToRoman;

public class Solution {

    public String intToRoman(int num) {
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder res = new StringBuilder();


        for (int i = 0; i <= values.length - 1; ++i) {
            String symbol = symbols[i];
            int value = values[i];

            while (num >= value) {
                res.append(symbol);
                num -= value;
            }
        }

        return res.toString();
    }
}
