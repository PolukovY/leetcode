package com.levik.leetcode.isSymmetric;

public class Solution {

    public class TreeNode {
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode rootLeft, TreeNode rootRight) {
        if (rootLeft == null || rootRight == null) {
            return rootLeft == rootRight;
        }

        if (rootLeft.val != rootRight.val) {
            return false;
        }

        return isSymmetric(rootLeft.left, rootRight.right) && isSymmetric(rootLeft.right, rootRight.left);
    }
}
