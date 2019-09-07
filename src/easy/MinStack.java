package easy;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * @author Renat Kaitmazov
 */

public final class MinStack {

    private final IntStack normalStackHead = new IntStack();
    private final IntStack minStackHead = new IntStack();

    public void push(int x) {
        normalStackHead.push(x);
        if (minStackHead.isEmpty()) {
            minStackHead.push(x);
            return;
        }
        final int minValue = minStackHead.peek();
        if (x <= minValue) {
            minStackHead.push(x);
        }
    }

    public void pop() {
        final int poppedValue = normalStackHead.pop();
        if (poppedValue == minStackHead.peek()) {
            minStackHead.pop();
        }
    }

    public int top() {
        return normalStackHead.peek();
    }

    public int getMin() {
        return minStackHead.peek();
    }

    // Need to create my own implementation to avoid boxing and unboxing.
    private static final class IntStack {

        private Node head;

        void push(int x) {
            final Node newNode = new Node(x);
            newNode.next = head;
            head = newNode;
        }

        int peek() {
            return head.value;
        }

        int pop() {
            final int value = head.value;
            head = head.next;
            return value;
        }

        boolean isEmpty() {
            return head == null;
        }

        private static final class Node {
            private final int value;
            private Node next;

            Node(int value) {
                this.value = value;
            }

            // For debugging
            @Override
            public String toString() {
                return String.valueOf(value);
            }
        }
    }
}
