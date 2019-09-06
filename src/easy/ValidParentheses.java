package easy;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * An input string is valid if:
 * • Open brackets must be closed by the same type of brackets.
 * • Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * @author Renat Kaitmazov
 */

public final class ValidParentheses {

    public boolean isValid(String s) {
        final int length = s.length();
        final int halfLength = (length >> 1) + length % 2;
        final byte[] stack = new byte[halfLength];
        int currentSymbolPointer = 0;
        for (int i = 0; i < length; ++i) {
            switch (s.charAt(i)) {
                case '[':
                    if (currentSymbolPointer == halfLength) return false;
                    stack[currentSymbolPointer++] = 0;
                    break;
                case '(':
                    if (currentSymbolPointer == halfLength) return false;
                    stack[currentSymbolPointer++] = 1;
                    break;
                case '{':
                    if (currentSymbolPointer == halfLength) return false;
                    stack[currentSymbolPointer++] = 2;
                    break;
                case '}':
                    if (currentSymbolPointer == 0) return false;
                    if (stack[--currentSymbolPointer] != 2) return false;
                    break;
                case ')':
                    if (currentSymbolPointer == 0) return false;
                    if (stack[--currentSymbolPointer] != 1) return false;
                    break;
                case ']':
                    if (currentSymbolPointer == 0) return false;
                    if (stack[--currentSymbolPointer] != 0) return false;
                    break;
            }
        }
        return currentSymbolPointer == 0;
    }
}
