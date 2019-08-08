package medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string S of '(' and ')' parentheses,
 * we add the minimum number of parentheses ( '(' or ')', and in any positions )
 * so that the resulting parentheses string is valid.
 * Formally, a parentheses string is valid if and only if:
 * • It is the empty string, or
 * • It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * • It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 * Note:
 *  S.length <= 1000
 *  S only consists of '(' and ')' characters.
 *
 * @author Renat Kaitmazov
 */

public final class MakeParenthesesValid {

    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    public int minAddToMakeValid(String str) {
        final Deque<Character> stack = new LinkedList<>();
        final int length = str.length();
        int missingParenthesis = 0;
        for (int i = 0; i < length; ++i) {
            final char currentChar = str.charAt(i);
            switch (currentChar) {
                case OPEN:
                    stack.push(currentChar);
                    break;
                case CLOSE:
                    if (stack.isEmpty()) {
                        ++missingParenthesis;
                        continue;
                    }
                    stack.pop();
                    break;
            }
        }
        return missingParenthesis + stack.size();
    }
}
