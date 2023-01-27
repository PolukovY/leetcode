package com.levik.leetcode.symmetricalTree;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProgramTest {


    @Test
    public void testCase1() {
        Program.BinaryTree tree = new Program.BinaryTree(10);
        tree.left = new Program.BinaryTree(5);
        tree.right = new Program.BinaryTree(5);
        tree.left.left = new Program.BinaryTree(7);
        tree.left.right = new Program.BinaryTree(9);
        tree.right.left = new Program.BinaryTree(9);
        tree.right.right = new Program.BinaryTree(7);
        var expected = true;
        var actual = new Program().symmetricalTree(tree);
        assertThat(expected).isEqualTo(actual);
    }

}