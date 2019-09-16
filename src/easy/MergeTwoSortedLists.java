package easy;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * @author Renat Kaitmazov
 */

public final class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = getSmaller(l1, l2);
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        if (head == l1) {
            l1 = l1.next;
        } else {
            l2 = l2.next;
        }
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
                continue;
            }
            if (l2 == null) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
                continue;
            }
            if (l2.val < l1.val) {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
                continue;
            }
            tail.next = l1;
            tail = l1;
            l1 = l1.next;
        }
        return head;
    }

    private ListNode getSmaller(ListNode lhs, ListNode rhs) {
        if (lhs == null && rhs == null) return null;
        if (lhs == null) return rhs;
        if (rhs == null) return lhs;
        if (rhs.val < lhs.val) return rhs;
        return lhs;
    }

    /**
     * Definition for singly-linked list.
     */
    public static final class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
