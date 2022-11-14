package com.levik.leetcode.preorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution2 {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    };

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            res.add(current.val);

            addChildrenInReverseOrder(current.children, stack);
        }


        return res;
    }

    private void addChildrenInReverseOrder(List<Node> children, Stack<Node> stack) {
        for (int i = children.size() - 1; i >= 0; i--) {
            stack.add(children.get(i));
        }
    }
}
