package com.levik.leetcode.mergeBinaryTrees;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProgramTest {

    @Test
    public void testCase1() {
        Program.BinaryTree tree1 = new Program.BinaryTree(1);
        tree1.left = new Program.BinaryTree(3);
        tree1.left.left = new Program.BinaryTree(7);
        tree1.left.right = new Program.BinaryTree(4);
        tree1.right = new Program.BinaryTree(2);

        Program.BinaryTree tree2 = new Program.BinaryTree(1);
        tree2.left = new Program.BinaryTree(5);
        tree2.left.left = new Program.BinaryTree(2);
        tree2.right = new Program.BinaryTree(9);
        tree2.right.left = new Program.BinaryTree(7);
        tree2.right.right = new Program.BinaryTree(6);

        Program.BinaryTree actual = new Program().mergeBinaryTrees(tree1, tree2);

        assertThat(actual.value).isEqualTo(2);
        assertThat(actual.left.value).isEqualTo(8);
        assertThat(actual.left.left.value).isEqualTo(9);
        assertThat(actual.left.right.value).isEqualTo(4);
        assertThat(actual.right.value).isEqualTo(11);
        assertThat(actual.right.left.value).isEqualTo(7);
        assertThat(actual.right.right.value).isEqualTo(6);
    }

}