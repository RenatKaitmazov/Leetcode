package easy;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * @author Renat Kaitmazov
 */

public final class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode previous = head;
        ListNode current = head.next;
        while (current != null) {
            if (previous.val == current.val) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }
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
