package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * @author Renat Kaitmazov
 */

public final class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        final int lhsSize = s.length();
        final int rhsSize = t.length();
        if (lhsSize != rhsSize) {
            return false;
        }
        final Map<Character, Integer> counter = new HashMap<>(lhsSize);
        for (int i = 0; i < lhsSize; ++i) {
            final char key = s.charAt(i);
            final Integer count = counter.get(key);
            counter.put(key, count == null ? 1 : count + 1);
        }
        for (int i = 0; i < rhsSize; ++i) {
            final char key = t.charAt(i);
            final Integer count = counter.get(key);
            if (count == null) {
                return false;
            }
            if (count == 1) {
                counter.remove(key);
                continue;
            }
            counter.put(key, count - 1);
        }
        return counter.isEmpty();
    }
}
