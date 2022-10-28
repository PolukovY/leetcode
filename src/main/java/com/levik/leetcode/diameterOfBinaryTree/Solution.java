package com.levik.leetcode.diameterOfBinaryTree;



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
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root){
        if(root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        ans = Math.max(ans, 2 + (left + right));
        return Math.max(left,right);
    }
}
