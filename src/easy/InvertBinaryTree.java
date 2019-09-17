package easy;

/**
 * Invert a binary tree.
 *
 * @author Renat Kaitmazov
 */

public final class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode node) {
        if (node == null) {
            return;
        }
        final TreeNode lhs = node.left;
        node.left   = node.right;
        node.right  = lhs;
        invert(node.left);
        invert(node.right);
    }

    /**
     * Definition for a binary tree node.
     */
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
