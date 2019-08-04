package medium;

/**
 * Given the root of a binary search tree with distinct values,
 * modify it so that every node has a new value
 * equal to the sum of the values of the original tree
 * that are greater than or equal to node.val.
 *
 * @author Renat Kaitmazov
 */

public class GreaterSumTree {

    public TreeNode bstToGst(TreeNode root) {
        helperMethod(root, 0);
        return root;
    }

    private int helperMethod(TreeNode node, int accumulatedSum) {
        if (node == null) return accumulatedSum;
        // We first need to explore the right subtree, since in BST right nodes are not
        // smaller the current node.
        node.val += helperMethod(node.right, accumulatedSum);
        // And then the left subtree, since nodes in that part are strictly smaller than the current node.
        return helperMethod(node.left, node.val);
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
