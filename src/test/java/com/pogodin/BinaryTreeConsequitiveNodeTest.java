package com.pogodin;

import com.pogodin.BinaryTreeConsequitiveNode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeConsequitiveNodeTest {

    @Test
    public void testSingleNodeTree()
    {
        // Single node tree
        TreeNode root = new TreeNode(1);
        BinaryTreeConsequitiveNode solver = new BinaryTreeConsequitiveNode();
        assertEquals(1, solver.findConseqPath(root));
    }

    @Test
    public void testConsecutiveTree()
    {
        // Tree with consecutive values
        //        1
        //         \
        //          2
        //           \
        //            3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        BinaryTreeConsequitiveNode solver = new BinaryTreeConsequitiveNode();
        assertEquals(3, solver.findConseqPath(root));  // The longest consecutive path is 1 -> 2 -> 3
    }

    @Test
    public void testNonConsecutiveTree()
    {
        // Tree with non-consecutive values
        //        5
        //       / \
        //      1   3
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        BinaryTreeConsequitiveNode solver = new BinaryTreeConsequitiveNode();
        assertEquals(1, solver.findConseqPath(root));  // No consecutive sequence, so the longest path is 1
    }

    @Test
    public void testMixedTree()
    {
        // Mixed consecutive and non-consecutive values
        //        2
        //       / \
        //      3   4
        //     /
        //    4
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(4);
        BinaryTreeConsequitiveNode solver = new BinaryTreeConsequitiveNode();
        assertEquals(3, solver.findConseqPath(root));  // The longest consecutive path is 2 -> 3 -> 4
    }

    @Test
    public void testLeftConsecutiveTree()
    {
        // Tree with consecutive values only on the left side
        //        1
        //       /
        //      2
        //     /
        //    3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        BinaryTreeConsequitiveNode solver = new BinaryTreeConsequitiveNode();
        assertEquals(3, solver.findConseqPath(root));  // The longest consecutive path is 1 -> 2 -> 3
    }

    @Test
    public void testComplexTree()
    {
        // Complex tree
        //        6
        //       / \
        //      7   8
        //     /     \
        //    8       9
        //   /
        //  9
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.left.left = new TreeNode(9);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(9);
        BinaryTreeConsequitiveNode solver = new BinaryTreeConsequitiveNode();
        assertEquals(4, solver.findConseqPath(root));  // The longest consecutive path is 6 -> 7 -> 8 -> 9
    }

    @Test
    public void testEmptyTree()
    {
        // Empty tree
        TreeNode root = null;
        BinaryTreeConsequitiveNode solver = new BinaryTreeConsequitiveNode();
        assertEquals(0, solver.findConseqPath(root));  // No nodes, return 0
    }
}