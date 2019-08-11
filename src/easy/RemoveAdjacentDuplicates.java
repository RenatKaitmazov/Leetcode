package easy;

/**
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent
 * and equal letters, and removing them.
 * We repeatedly make duplicate removals on S until we no longer can.
 * Return the final string after all such duplicate removals have been made.
 * It is guaranteed the answer is unique.
 * <p>
 * Note:
 * • 1 <= S.length <= 20000
 * • S consists only of English lowercase letters.
 *
 * @author Renat Kaitmazov
 */

public final class RemoveAdjacentDuplicates {

    public String removeDuplicates(String str) {
        final int length = str.length();
        final char[] stack = new char[length];
        int stackPointer = 0;
        for (int i = 0; i < length; ++i) {
            final char currentChar = str.charAt(i);
            if      (stackPointer == 0) stack[stackPointer++] = currentChar;
            else if (stack[stackPointer - 1] == currentChar) --stackPointer;
            else stack[stackPointer++] = currentChar;
        }
        return new String(stack, 0, stackPointer);
    }
}
