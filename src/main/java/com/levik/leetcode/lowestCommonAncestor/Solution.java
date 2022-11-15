package com.levik.leetcode.lowestCommonAncestor;

public class Solution {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val = root.val;
        if (p.val < val && q.val < val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.val > val && q.val > val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;

    }
}
