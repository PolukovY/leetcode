package com.levik.leetcode.heightBalancedBinaryTree;

public class Program {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        if (tree == null) {
            return true;
        }

        return heightBalancedBinaryTreeHelper(tree.left, tree.right);
    }

    private boolean heightBalancedBinaryTreeHelper(BinaryTree left, BinaryTree right) {
        if (left == null || right == null) {
            return false;
        }

        if (left != null && right == null) {
            return false;
        }

        if (left == null && right != null) {
            return false;
        }

        

        return false;
    }
}
