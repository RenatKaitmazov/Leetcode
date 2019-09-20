package medium;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * • The left subtree of a node contains only nodes with keys less than the node's key.
 * • The right subtree of a node contains only nodes with keys greater than the node's key.
 * • Both the left and right subtrees must also be binary search trees.
 *
 * @author Renat Kaitmazov
 */

public final class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long min, long max) {
        if (node == null) return true;
        final int value = node.val;
        if (value <= min || value >= max) return false;
        return isValid(node.left, min, value) && isValid(node.right, value, max);
    }

    /**
     * Definition for a binary tree node.
     */
    private static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
