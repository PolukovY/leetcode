package com.levik.leetcode.preorder;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    };

    public List<Integer> preorder(Node root) {
        List<Integer> nodes = new ArrayList<>();
        dfs(root, nodes);
        return nodes;
    }

    private void dfs(Node root, List<Integer> nodes) {
        if (root == null) {
            return;
        }

        nodes.add(root.val);

        for(Node node: root.children) {
            dfs(node, nodes);
        }
    }

}
