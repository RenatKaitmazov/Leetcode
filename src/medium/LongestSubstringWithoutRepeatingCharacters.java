package medium;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * @author Renat Kaitmazov
 */

public class LongestSubstringWithoutRepeatingCharacters {

    private static final int ALPHABET_SIZE = 128;

    public int lengthOfLongestSubstring(String str) {
        final int length = str.length();
        if (length < 2) {
            return length;
        }
        final int initialValue = -1;
        final int[] encounteredIndices = newArray(ALPHABET_SIZE, initialValue);
        int start = 0;
        int end;
        int longestSubstringLength = 0;
        for (end = 0; end < length; ++end) {
            final int charIndex = str.charAt(end);
            final int encounteredIndex = encounteredIndices[charIndex];
            if (encounteredIndex == initialValue) {
                encounteredIndices[charIndex] = end;
                continue;
            }
            final int substringLength = end - start;
            if (substringLength > longestSubstringLength) {
                longestSubstringLength = substringLength;
            }
            for (int i = start; i < encounteredIndex; ++i) {
                encounteredIndices[str.charAt(i)] = initialValue;
            }
            encounteredIndices[charIndex] = end;
            start = encounteredIndex + 1;
        }
        return Math.max(longestSubstringLength, end - start);
    }

    private int[] newArray(int size, int initValue) {
        final int[] array = new int[size];
        if (initValue != 0) {
            for (int i = 0; i < size; ++i) {
                array[i] = initValue;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        final LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("cdd"));
        System.out.println(l.lengthOfLongestSubstring("qwertyuiop"));
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstring("bbbbb"));
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
        System.out.println(l.lengthOfLongestSubstring("abba"));
    }
}
