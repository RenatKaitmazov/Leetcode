package easy;

/**
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 * <p>
 * • if S[i] == "I", then A[i] < A[i+1]
 * • if S[i] == "D", then A[i] > A[i+1]
 *
 * @author Renat Kaitmazov
 */

public final class DIStringMatch {

    private static final char INCREASE = 'I';
    private static final char DECREASE = 'D';

    public int[] diStringMatch(String str) {
        final int length = str.length();
        final int[] result = new int[length + 1];
        int min = 0, max = length;
        for (int i = 0; i < length; ++i) {
            switch (str.charAt(i)) {
                case INCREASE:
                    result[i] = min++;
                    break;
                case DECREASE:
                    result[i] = max--;
                    break;
            }
        }
        result[length] = min;
        return result;
    }
}
