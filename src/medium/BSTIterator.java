package medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note:
 * • next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * • You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
 *
 * @author Renat Kaitmazov
 */

public final class BSTIterator {

    private final Deque<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        for (TreeNode node = root; node != null; node = node.left) {
            stack.push(node);
        }
    }

    public int next() {
        final TreeNode next = stack.pop();
        for (TreeNode node = next.right; node != null; node = node.left) {
            stack.push(node);
        }
        return next.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
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
