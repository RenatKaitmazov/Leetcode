package easy;

/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 *
 * @author Renat Kaitmazov
 */

public final class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode middle = head;
        try {
            ListNode end = head.next;
            while (end != null) {
                middle = middle.next;
                end = end.next.next;
            }
        } catch (NullPointerException error) {
        }
        return middle;
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
