package com.pogodin;

/**
 * In a binary tree, find the longest path
 * where each consecutive node has a value incremented by 1 from the parent node.
 */
public class BinaryTreeConsequitiveNode {
    private int localRes = 0;

    public Integer findConseqPath(TreeNode root) {
        if (root != null) {
            findPath(root, root.val + 1, 1);
        }
        return localRes;
    }

    public void findPath(TreeNode node, int expectedVal, int length) {
        if (node == null) {
            return;
        }

        if (node.val == expectedVal) {
            length++;
        } else {
            length = 1;
        }

        localRes = Math.max(localRes, length);
        findPath(node.left, node.val + 1, length);
        findPath(node.right, node.val + 1, length);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
