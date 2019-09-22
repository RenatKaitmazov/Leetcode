package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * @author Renat Kaitmazov
 */

public final class BSTInOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        final Deque<TreeNode> stack = new LinkedList<>();
        for (TreeNode current = root; current != null; current = current.left) {
            stack.push(current);
        }
        final List<Integer> numbers = new ArrayList<>();
        while (!stack.isEmpty()) {
            final TreeNode smallestNode = stack.pop();
            numbers.add(smallestNode.val);
            for (TreeNode node = smallestNode.right; node != null; node = node.left) {
                stack.push(node);
            }
        }
        return numbers;
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
