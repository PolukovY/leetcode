package com.levik.traning.day3;

public class T02 {

    /**
     * Дано однозвʼязаний список, в якому (для простоти) є тільки цілі числа.
     * Треба визначити чи є цикл в цьому списку.
     * Циклом ми називаємо множину елементів які формують "кільце"
     * Наприклад:
     * 1 -> 2 -> 3 -> 4 -> 5
     * .....|--------------|
     *
     * Тут елемент (5) вказує знову на елемент (2) і створує цикл таким чином.
     *
     * На вход дається обʼєкт Node (val, next).
     * Функція має повернути TRUE якщо цикл існує, або FALSE якщо його немає.
     *
     * Доповнювати структуру Node неможна, так само як змінювати значення елементів.
     * Відомо, що ця структура даних може бути дуже великою, тому рішення має
     * працювати без додаткової памʼяті.
     *
     * Майте на увазі, що приклади містять числа упорядковані тільки для кращої
     * візуалізації, упорядкованість даних НЕ гарантується.
     */
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node prev) {
            this.val = val;
            prev.next = this;
        }
    }

    public static boolean solve(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head.next;

        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2, n1);
        Node n3 = new Node(3, n2);
        Node n4 = new Node(4, n3);
        Node n5 = new Node(5, n4);
        // n1 -> n2 -> n3 -> n4 -> n5

        n5.next = n2;
        System.out.println(solve(n1));
        assert solve(n1) == true;
        //assert (this.solve(n1)).isEqualTo(true);
        n5.next = null;
        System.out.println(solve(n1));
        assert solve(n1) == false;
        //assertThat(this.solve(n1)).isEqualTo(false);
        n5.next = n1;
        assert solve(n1) == true;
        System.out.println(solve(n1));
        //assertThat(this.solve(n1)).isEqualTo(true);
        n5.next = n4;
        System.out.println(solve(n1));
        assert solve(n1) == true;
        //assertThat(this.solve(n1)).isEqualTo(true);

        Node a1 = new Node(10);
        System.out.println(solve(a1));
        assert solve(a1) == false;
        //assertThat(this.solve(a1)).isEqualTo(false);
        a1.next = a1;
        assert solve(a1) == true;
        System.out.println(solve(a1));
        //assertThat(this.solve(a1)).isEqualTo(true);
    }
}
