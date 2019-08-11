package easy;

/**
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent
 * and equal letters, and removing them.
 * We repeatedly make duplicate removals on S until we no longer can.
 * Return the final string after all such duplicate removals have been made.
 * It is guaranteed the answer is unique.
 *
 * Note:
 * • 1 <= S.length <= 20000
 * • S consists only of English lowercase letters.
 *
 * @author Renat Kaitmazov
 */

public final class RemoveAdjacentDuplicates {

    public String removeDuplicates(String str) {
        final int length = str.length();
        final StringBuilder builder = new StringBuilder();
        builder.append(str.charAt(0));
        for (int i = 1; i < length; ++i) {
            final char currentChar = str.charAt(i);
            final int builderLength = builder.length();
            if (builderLength == 0) {
                builder.append(currentChar);
                continue;
            }
            final char prevChar = builder.charAt(builderLength - 1);
            if (prevChar == currentChar) {
                builder.deleteCharAt(builderLength - 1);
                continue;
            }
            builder.append(currentChar);
        }
        return builder.toString();
    }
}
