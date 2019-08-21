package easy;

/**
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B,
 * where A and B are valid parentheses strings, and + represents string concatenation.
 * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 * A valid parentheses string S is primitive if it is nonempty,
 * and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
 * Given a valid parentheses string S,
 * consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
 * Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
 * Note:
 * • S.length <= 10000
 * • S[i] is "(" or ")"
 * • S is a valid parentheses string
 *
 * @author Renat Kaitmazov
 */

public final class RemoveOutermostParentheses {

    private static final char OPEN  = '(';
    private static final char CLOSE = ')';

    public String removeOuterParentheses(String str) {
        final int size = str.length();
        if (size < 1) {
            return str;
        }
        final byte[] newStr = new byte[size];
        int openedParenthesesCount = 0;
        int lastCharIndex = 0;
        for (int i = 0; i < size; ++i) {
            final char currentChar = str.charAt(i);
            switch (currentChar) {
                case OPEN:
                    if (openedParenthesesCount > 0) {
                        newStr[lastCharIndex++] = (byte) currentChar;
                    }
                    ++openedParenthesesCount;
                    break;
                case CLOSE:
                    if (openedParenthesesCount > 1) {
                        newStr[lastCharIndex++] = (byte) currentChar;
                    }
                    --openedParenthesesCount;
                    break;
            }
        }
        return new String(newStr, 0, lastCharIndex);
    }
}
