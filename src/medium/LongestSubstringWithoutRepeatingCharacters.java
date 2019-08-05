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
        final int[] encounteredIndices = new int[ALPHABET_SIZE];
        int longestSubstringLength = 0;
        // S is the start of the substring, e is the end.
        for (int s = 0, e = 0; e < length; ++e) {
            final int currentChar = str.charAt(e);
            final int encounteredIndex = encounteredIndices[currentChar];
            if (encounteredIndex > s) {
                // Update the start position only if the index of the duplicate char is farther,
                // than the current start position.
                s = encounteredIndex;
            }
            final int substringLength = e - s + 1;
            if (substringLength > longestSubstringLength) {
                longestSubstringLength = substringLength;
            }
            // +1 is used as a padding, since all values in a newly created array are zeroes.
            encounteredIndices[currentChar] = e + 1;
        }
        return longestSubstringLength;
    }
}
