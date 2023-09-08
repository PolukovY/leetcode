package com.levik.design.chat.custome.chat.persistent;

import java.util.ArrayList;
import java.util.List;

public class CycleList<T> {
    private Node<T> head;
    private int size;

    public void add(T item, long ttlMillis) {
        long expirationTime = System.currentTimeMillis() + ttlMillis;
        Node<T> newNode = new Node<>(item, expirationTime);
        if (head == null) {
            head = newNode;
            head.prev = head;
            head.next = head;
        } else {
            newNode.prev = head;
            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
            head = newNode;
        }
        size++;
    }

    public void remove(T item) {
        if (head == null) {
            return;
        }

        Node<T> currNode = head.next;
        while (currNode != head) {
            if (currNode.item.equals(item)) {
                currNode.prev.next = currNode.next;
                currNode.next.prev = currNode.prev;
                size--;
                return;
            }
            currNode = currNode.next;
        }

        if (head.item.equals(item)) {
            head.prev.next = head.next;
            head.next.prev = head.prev;
            head = head.prev;
            size--;
        }
    }

    public synchronized void cleanupExpiredItems() {
        if (head == null) {
            return;
        }

        long currentTime = System.currentTimeMillis();
        Node<T> currNode = head.next;
        while (currNode != head) {
            if (currNode.expirationTime <= currentTime) {
                currNode.prev.next = currNode.next;
                currNode.next.prev = currNode.prev;
                size--;
            }
            currNode = currNode.next;
        }

        if (head.expirationTime <= currentTime) {
            head.prev.next = head.next;
            head.next.prev = head.prev;
            head = head.prev;
            size--;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public List<T> getAll() {
        List<T> items = new ArrayList<>();
        if (head == null) {
            System.out.println("List is empty.");
            return items;
        }

        Node<T> currNode = head.next;
        items.add(head.item);
        System.out.print(head.item + " ");

        while (currNode != head) {
            items.add(currNode.item);
            System.out.print(currNode.item + " ");
            currNode = currNode.next;
        }

        System.out.println();

        return items;
    }

    private static class Node<T> {
        private final T item;
        private final long expirationTime;
        private Node<T> prev;
        private Node<T> next;

        public Node(T item, long expirationTime) {
            this.item = item;
            this.expirationTime = expirationTime;
            this.prev = null;
            this.next = null;
        }
    }
}

