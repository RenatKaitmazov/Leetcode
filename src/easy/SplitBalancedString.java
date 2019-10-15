package easy;

/**
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * <p>
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * <p>
 * Return the maximum amount of split balanced strings.
 *
 * @author Renat Kaitmazov
 */

public final class SplitBalancedString {

    private static final char LEFT  = 'L';
    private static final char RIGHT = 'R';

    public int balancedStringSplit(String s) {
        final int size = s.length();
        if (size < 1) {
            return 0;
        }
        int balance = s.charAt(0) == LEFT ? 1 : -1;
        int count = 0;
        for (int i = 1; i < size; ++i) {
            switch (s.charAt(i)) {
                case LEFT:
                    ++balance;
                    break;
                case RIGHT:
                    --balance;
                    break;
            }
            if (balance == 0) {
                ++count;
            }
        }
        return count;
    }
}
