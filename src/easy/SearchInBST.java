package easy;

/**
 * Given the root node of a binary search tree (BST) and a value.
 * You need to find the node in the BST that the node's value equals the given value.
 * Return the subtree rooted with that node.
 * If such node doesn't exist, you should return NULL.
 *
 * @author Renat Kaitmazov
 */

public final class SearchInBST {

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode current = root;
        while (current != null) {
            if      (current.val < val) current = current.right;
            else if (current.val > val) current = current.left;
            else return current;
        }
        return null;
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
