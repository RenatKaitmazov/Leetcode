package medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * @author Renat Kaitmazov
 */

public final class AddTwoNumbers {

    private static final int RADIX = 10;

    public ListNode addTwoNumbers(ListNode lhs, ListNode rhs) {
        if (lhs == null) return rhs;
        if (rhs == null) return lhs;
        int carry = 0;
        ListNode head = null;
        ListNode tail = null;
        while (lhs != null || rhs != null) {
            final int lhsVal = lhs == null ? 0 : lhs.val;
            final int rhsVal = rhs == null ? 0 : rhs.val;
            final int sum = carry + lhsVal + rhsVal;
            carry = sum >= RADIX ? 1 : 0;
            final ListNode sumNode = new ListNode(sum % RADIX);
            if (head == null) {
                head = sumNode;
                tail = sumNode;
            }
            else {
                tail.next = sumNode;
                tail = sumNode;
            }
            if (lhs != null) lhs = lhs.next;
            if (rhs != null) rhs = rhs.next;
        }
        if (carry > 0) tail.next= new ListNode(carry);
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
