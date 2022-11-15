package com.levik.leetcode.isValidBST;

import java.util.Stack;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long minVal = Long.MIN_VALUE;

        if (root == null) {
            return true;
        }

        while(!stack.isEmpty() || root !=null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (root.val <= minVal) {
                return false;
            }

            minVal = root.val;
            root = root.right;
        }

        return true;
    }
}
