package com.levik.leetcode.tinyurl;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Generator {

    private static final int NUM_CHARS_SHORT_LINK = 7;
    private static final String TEXT = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private static final Set<String> GENERATED_URLS = new HashSet<>();

    public String generateRandomShortUrl() {
        String result;
        char[] charArray = TEXT.toCharArray();

        while (true) {
            char[] shortUrl = generateHelper(charArray);
            result = toString(shortUrl);
            if (!GENERATED_URLS.contains(result)) {
                GENERATED_URLS.add(result);
                break;
            } else {
                System.out.println("conflict....");
            }
        }

        return result;
    }

    private static char[] generateHelper(char[] source) {
        char[] shortUrl = new char[NUM_CHARS_SHORT_LINK];

        for (int i = 0 ;i < NUM_CHARS_SHORT_LINK;i++) {
            int index = new Random().nextInt(TEXT.length());
            shortUrl[i] = source[index];
        }

        return shortUrl;
    }

    private String toString(char[] chars) {
        StringBuilder result = new StringBuilder();
        for (char aChar : chars) {
            result.append(aChar);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1_000; i++) {
            String s = new Generator().generateRandomShortUrl();
            System.out.println(s);
        }

    }
}
