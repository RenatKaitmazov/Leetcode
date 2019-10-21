package easy;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * @author Renat Kaitmazov
 */

public final class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        final int sizeA = size(headA);
        final int sizeB = size(headB);
        ListNode longer = headA;
        ListNode shorter = headB;
        if (sizeB > sizeA) {
            longer = headB;
            shorter = headA;
        }
        final int diff = Math.abs(sizeA - sizeB);
        for (int i = 0; i < diff; ++i) {
            longer = longer.next;
        }
        if (longer == shorter) {
            return longer;
        }
        while (longer != null) {
            if (longer.next == shorter.next) {
                return longer.next;
            }
            longer = longer.next;
            shorter = shorter.next;
        }
        return null;
    }

    private int size(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            ++size;
            current = current.next;
        }
        return size;
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
