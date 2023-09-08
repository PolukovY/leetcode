package com.levik.ju3;

public class LinkedListDemo {

    public static void main(String[] args) {
        Node<Integer> linkedList = createLinkedList(1, 2, 3, 4);
        printLinkedList(linkedList);

        printLinkedListReversed(linkedList);
    }

    public static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }

    private static <T> Node<T> createLinkedList(T... elements){
        Node<T> head = new Node<>(elements[0]);
        var current = head;

        for (int i = 1; i < elements.length; i++) {
            T element = elements[i];
            current.next = new Node<>(element);
            current = current.next;
        }

        return head;
    }


    // 1 -> 2 -> 3 -> 4 -> 5
    private static void printLinkedList(Node<?> head) {
        Node<?> current = head;

        while(current.next != null) {
            System.out.print(current.element + " -> ");
            current = current.next;
        }

        System.out.println(current.element);
    }

    // 5 -> 4 -> 3 -> 2 -> 1
    private static void printLinkedListReversed(Node<?> head) {
        if (head != null) {
            printLinkedListReversed(head.next);
            System.out.println(head.element);
        }
    }

}
