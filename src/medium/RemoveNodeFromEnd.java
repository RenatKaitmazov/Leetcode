package medium;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Note:
 * • Given n will always be valid.
 * <p>
 * Follow up:
 * • Could you do this in one pass?
 *
 * @author Renat Kaitmazov
 */

public final class RemoveNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nodeToRemove = head;
        ListNode currentNode = head;
        // Make use of the fact than N is always valid.
        for (int i = 1; i < n; ++i) {
            currentNode = currentNode.next;
        }
        ListNode prev = head;
        for (; currentNode.next != null; currentNode = currentNode.next) {
            prev = nodeToRemove;
            nodeToRemove = nodeToRemove.next;
        }
        if (nodeToRemove == head) {
            return head.next;
        }
        prev.next = nodeToRemove.next;
        return head;
    }

    /**
     * Definition for singly-linked list.
     */
    private static final class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
