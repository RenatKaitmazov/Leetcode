package easy;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * @author Renat Kaitmazov
 */

public final class BTDiameter {

    public int diameterOfBinaryTree(TreeNode root) {
        final int[] memory = new int[1];
        calculateDiameter(root, memory);
        return memory[0];
    }

    private int calculateDiameter(TreeNode node, int[] memory) {
        if (node == null) {
            return 0;
        }
        final int left = calculateDiameter(node.left, memory);
        final int right = calculateDiameter(node.right, memory);
        final int currentDiameter = left + right;
        final int maxDiameter = memory[0];
        if (currentDiameter > maxDiameter) {
            memory[0] = currentDiameter;
        }
        return 1 + Math.max(left, right);
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
