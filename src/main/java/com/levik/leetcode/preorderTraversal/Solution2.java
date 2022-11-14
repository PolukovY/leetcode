package com.levik.leetcode.preorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {

    public class TreeNode {
        int val;
        Solution2.TreeNode left;
        Solution2.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, Solution2.TreeNode left, Solution2.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            res.add(current.val);

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return res;
    }
}
