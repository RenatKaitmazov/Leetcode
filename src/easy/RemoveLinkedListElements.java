package easy;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * @author Renat Kaitmazov
 */

public final class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode current = head;
        while (current != null && current.val == val) {
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        final ListNode newHead = current;
        ListNode previous = current;
        current = current.next;
        while (current != null) {
            if (current.val == val) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }
        return newHead;
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
