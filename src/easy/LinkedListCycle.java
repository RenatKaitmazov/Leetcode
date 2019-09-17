package easy;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * @author Renat Kaitmazov
 */

public final class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slower = head;
        ListNode faster = slower.next;
        while (faster != null) {
            if (faster == slower) {
                return true;
            }
            slower = slower.next;
            faster = faster.next;
            if (faster == null) {
                break;
            }
            faster = faster.next;
        }
        return false;
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
