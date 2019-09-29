package easy;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * <p>
 * Note:
 * • The linked list will have at least two elements.
 * • All of the nodes' values will be unique.
 * • The given node will not be the tail and it will always be a valid node of the linked list.
 * • Do not return anything from your function.
 *
 * @author Renat Kaitmazov
 */

public final class DeleteNodeInLinkedList {

    public void deleteNode(ListNode node) {
        ListNode previous = node;
        ListNode current = node;
        while (current.next != null) {
            final ListNode next = current.next;
            current.val = next.val;
            previous = current;
            current = next;
        }
        previous.next = null;
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
