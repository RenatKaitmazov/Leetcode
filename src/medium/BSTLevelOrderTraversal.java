package medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 *
 * @author Renat Kaitmazov
 */

public final class BSTLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> listOfLists = new LinkedList<>();
        if (root != null) {
            final Deque<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            while (!nodes.isEmpty()) {
                listOfLists.add(traversePerLevel(nodes));
            }
        }
        return listOfLists;
    }

    private List<Integer> traversePerLevel(Deque<TreeNode> nodes) {
        final TreeNode lastNode = nodes.getLast();
        final List<Integer> levelValues = new LinkedList<>();
        while (true) {
            final TreeNode node = nodes.removeFirst();
            final TreeNode left = node.left;
            if (left != null) {
                nodes.add(left);
            }
            final TreeNode right = node.right;
            if (right != null) {
                nodes.add(right);
            }
            levelValues.add(node.val);
            if (node == lastNode) {
                break;
            }
        }
        return levelValues;
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
