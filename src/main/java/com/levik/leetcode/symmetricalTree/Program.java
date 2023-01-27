package com.levik.leetcode.symmetricalTree;

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

    public boolean symmetricalTree(BinaryTree tree) {
        if (tree == null) {
            return true;
        }

        return isSymmetricalTreeHelper(tree.left, tree.right);
    }


    private boolean isSymmetricalTreeHelper(BinaryTree left, BinaryTree right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.value != right.value) {
            return true;
        }

        boolean isSymmetricalTreeLeftLef = isSymmetricalTreeHelper(left.left, right.right);
        boolean isSymmetricalTreeRightLef = isSymmetricalTreeHelper(left.right, right.left);

        return isSymmetricalTreeLeftLef && isSymmetricalTreeRightLef;

    }
}
