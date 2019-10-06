package easy;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * @author Renat Kaitmazov
 */

public final class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        final int size = size(head);
        final int halfSize = size >> 1;
        final int[] values = new int[halfSize];
        ListNode current = head;
        for (int i = 0; i < halfSize; ++i) {
            values[i] = current.val;
            current = current.next;
        }
        if ((size & 1) != 0) {
            current = current.next;
        }
        for (int i = halfSize - 1; i > -1; --i) {
            if (values[i] != current.val) {
                return false;
            }
            current = current.next;
        }
        return true;
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
