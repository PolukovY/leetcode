package com.levik.traning.day2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Рядок з дужками вважається правильним якщо:
 * - Це порожній рядок
 * - Він може бути записаний як AB (А з'єднаний з В), де А і В є правильними
 * - Він може бути записаний як (А), де А є правильним
 *
 * Дано рядок S. За одну операцію ви можете вставити дужку на будь-яку позицію у
 * рядку.
 * Наприклад, якщо s = "()))", ви можете вставити відкриваючу дужку і отримати
 * "(()))", або закриваючу і отримати "())))".
 *
 * Порахуйте мінімальну кількість операцій потрібних щоб зробити рядок S
 * правильним
 *
 * Приклад:
 * Input: s = "())"
 * Output: 1
 * Приклад 2:
 * Input: s = "))(())(("
 * Output: 4, бо треба додати 2 "(" з початку, та 2 ")" в кінці
 */
public class T02 {

    //time O(n), space O(n)
    private int solve(String s) {
        Map<Character, Character> dictionary = new HashMap<>();
        dictionary.put('(', ')');
        dictionary.put(')', '(');
        int count = 0;

        Stack<Character> stack = new Stack<>();


        for (char aChar :  s.toCharArray()) {
            if (aChar == '(') {
                stack.push(aChar);
            } else {
                if (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    Character prevCharacter = dictionary.get(pop);

                    if (prevCharacter != aChar) {
                        count++;
                    }
                } else {
                    count++;
                }
            }
        }

        if (!stack.isEmpty()) {
            count += stack.size();
        }

        return count;
    }

    public static void main(String[] args) {
        int solve = new T02().solve("");
        System.out.println(solve);
    }

}
