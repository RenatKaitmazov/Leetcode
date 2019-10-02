package easy;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * You may assume that there is only lower case English letters in both s and t.
 * t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some
 * (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 *
 * @author Renat Kaitmazov
 */

public final class IsSequence {

    public boolean isSubsequence(String subStr, String str) {
        final int subStrLength = subStr.length();
        if (subStrLength == 0) {
            return true;
        }
        final int strLength = str.length();
        int index = search(str, strLength, 0, subStr.charAt(0));
        if (index < 0) {
            return false;
        }
        for (int i = 1; i < subStrLength; ++i) {
            final char key = subStr.charAt(i);
            final int newIndex = search(str, strLength, index + 1, key);
            if (newIndex < index) {
                return false;
            }
            index = newIndex;
        }
        return true;
    }

    private int search(String str, int size, int start, char key) {
        for (int i = start; i < size; ++i) {
            if (key == str.charAt(i)) {
                return i;
            }
        }
        return -1;
    }

//    Follow-up solution:
//    private static final int ALPHABET_SIZE = 26;
//    private static final int OFFSET = 'a';
//
//    public boolean isSubsequence(String subStr, String str) {
//        final List<Integer>[] charIndices = (List<Integer>[]) new ArrayList[ALPHABET_SIZE];
//        final int strLength = str.length();
//        for (int i = 0; i < strLength; ++i) {
//            final int key = str.charAt(i) - OFFSET;
//            List<Integer> indices = charIndices[key];
//            if (indices == null) {
//                final List<Integer> newIndices = new ArrayList<>();
//                newIndices.add(i);
//                charIndices[key] = newIndices;
//            } else {
//                indices.add(i);
//            }
//        }
//        final int subStrLength = subStr.length();
//        if (subStrLength > 0) {
//            int key = subStr.charAt(0) - OFFSET;
//            final List<Integer> list = charIndices[key];
//            if (list == null) {
//                return false;
//            }
//            int lastIndex = list.get(0);
//            for (int i = 1; i < subStrLength; ++i) {
//                key = subStr.charAt(i) - OFFSET;
//                final List<Integer> indices = charIndices[key];
//                if (indices == null) {
//                    return false;
//                }
//                final int index = bs(indices, lastIndex + 1);
//                if (index < lastIndex) {
//                    return false;
//                }
//                lastIndex = index;
//            }
//        }
//        return true;
//    }
//
//    private int bs(List<Integer> list, int target) {
//        final int size = list.size();
//        int s = 0;
//        int e = size - 1;
//        while (s <= e) {
//            final int guessIndex = (s + e) >> 1;
//            final int guess = list.get(guessIndex);
//            if      (target < guess) e = guessIndex - 1;
//            else if (target > guess) s = guessIndex + 1;
//            else return guess;
//        }
//        return s >= size ? -1 : list.get(s);
//    }
}
