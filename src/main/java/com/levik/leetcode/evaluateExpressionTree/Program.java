package com.levik.leetcode.evaluateExpressionTree;

public class Program {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int evaluateExpressionTree(BinaryTree tree) {
        if (tree.value >= 0) {
            return tree.value;
        }

        int left = evaluateExpressionTree(tree.left);
        int right = evaluateExpressionTree(tree.right);

        if (tree.value == -1) {
            return left + right;
        } else if (tree.value == -2) {
            return left - right;
        } else if (tree.value == -3) {
            return left / right;
        }

        return left * right;
    }
}
