package com.levik.traning.day2;


/**
 * Дано закодований рядок, поверніть розкодований рядок.
 *
 * Правильно кодування наступне: k[encoded_str], де encoded_str усередині
 * квадратних дужок повторюється рівно k разів.
 * k гарантовано позитивне число.
 *
 * Ви можете бути впевнені, що вхідний рядок завжди валідний;
 * там немає зайвих пробілів, квадратні дужки правильно стоять, ітд
 *
 * Більше того, ви можете бути впевнені, що оригінальний рядок не містить чисел
 * та числа використовуються тільки для повторень (k).
 * Тобто числа тільки вказують на кількість повторень закодованої частини.
 * Наприклад, не може бути вхідного рядка як "3a" або "2[4]".
 *
 * Приклад:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 *
 * "3[a2[c]]", "accaccacc",
 *
 * Додатково: в цьому завданні важливо зробити саме гарне рекурсивне рішення для максимального балу.
 */
public class T03 {

    //time - O(n), space - O(n)
    public static String solve(String s) {
        var result = new StringBuilder();
        int repeat = 0;

        for (int i = 0; i < s.length(); i++) {
            char aChar = s.charAt(i);

            if (Character.isDigit(aChar)) {
                repeat = repeat * 10 + Character.getNumericValue(aChar);
            } else if (aChar == '[') {
                int startIndex = i + 1;
                int closingBracketIndex = findClosingBracket(s, startIndex);
                var substring = s.substring(startIndex, closingBracketIndex);
                var str = solve(substring);
                result.append(str.repeat(repeat));
                repeat = 0;
                i = closingBracketIndex;
            } else {
                result.append(aChar);
            }
        }

        return result.toString();
    }

    private static int findClosingBracket(String s, int start) {
        int closeBracketCount = 1;

        for (int i = start; i < s.length(); i++) {
            char aChar = s.charAt(i);
            if (aChar == '[') {
                closeBracketCount++;
            } else if (aChar == ']') {
                closeBracketCount--;
                if (closeBracketCount == 0) {
                    return i;
                }
            }
        }
        return -1;
    }



    /*public static String solve(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c);
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(result);
                result = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                StringBuilder tmp = result;
                result = strStack.pop();
                int repeatTimes = numStack.pop();
                result.append(String.valueOf(tmp).repeat(Math.max(0, repeatTimes)));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }*/

    public static void main(String[] args) {
        //System.out.println(solve("3[a]2[bc]"));  // Output: "aaabcbc"
        System.out.println(solve("3[a2[c]]"));  // Output: "accaccacc"
    }
}
