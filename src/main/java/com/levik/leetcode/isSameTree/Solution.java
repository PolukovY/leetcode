package com.levik.leetcode.isSameTree;

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
         if (p == null && q == null) {
             return true;
         }

         if (p != null && q != null && p.val == q.val) {
             boolean isLeftTheSame = isSameTree(p.left, q.left);
             boolean isRightTheSame = isSameTree(p.right, q.right);

             return isLeftTheSame && isRightTheSame;
         }

         return false;
    }
}
