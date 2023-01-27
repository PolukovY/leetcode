package com.levik.leetcode.mergeBinaryTrees;

import java.util.Stack;

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

    public BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {
        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();
        stack1.add(tree1);
        stack2.add(tree2);

        while(!stack1.isEmpty()) {
            var firstTree = stack1.pop();
            var secondTree = stack2.pop();

            if (secondTree == null) {
                continue;
            }


            firstTree.value += secondTree.value;

            if (firstTree.left != null) {
                stack1.push(firstTree.left);
                stack2.push(secondTree.left);
            } else {
                firstTree.left = secondTree.left;
            }

            if (firstTree.right != null) {
                stack1.push(firstTree.right);
                stack2.push(secondTree.right);
            } else {
                firstTree.right = secondTree.right;
            }
        }

        return tree1;
    }
}
