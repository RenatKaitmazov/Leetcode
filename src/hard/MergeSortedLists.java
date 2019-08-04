package hard;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 *
 * @author Renat Kaitmazov
 */

public class MergeSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        final int size = lists.length;
        if (size == 0) return null;
        return sort(lists, 0, size - 1);
    }

    private ListNode sort(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        final int middle = start + ((end - start) >> 1);
        // Sort left half.
        final ListNode lhs = sort(lists, start, middle);
        // Sort right half.
        final ListNode rhs = sort(lists, middle + 1, end);
        // Combine the result.
        return merge(lhs, rhs);
    }

    private ListNode merge(ListNode lhs, ListNode rhs) {
        if (lhs == null) return rhs;
        if (rhs == null) return lhs;
        ListNode lhsPointer = lhs;
        ListNode rhsPointer = rhs;
        ListNode head = null;
        ListNode tail = null;
        while (lhsPointer != null || rhsPointer != null) {
            final ListNode nextNode;
            if (lhsPointer == null) {
                nextNode = rhsPointer;
                rhsPointer = rhsPointer.next;
            } else if (rhsPointer == null) {
                nextNode = lhsPointer;
                lhsPointer = lhsPointer.next;
            } else {
                if (rhsPointer.val < lhsPointer.val) {
                    nextNode = rhsPointer;
                    rhsPointer = rhsPointer.next;
                } else {
                    nextNode = lhsPointer;
                    lhsPointer = lhsPointer.next;
                }
            }
            if (head == null) {
                head = nextNode;
            } else {
                tail.next = nextNode;
            }
            tail = nextNode;
        }
        return head;
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
