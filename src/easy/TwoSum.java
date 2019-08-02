package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that
 * they add up to a specific target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * @author Renat Kaitmazov
 */

public final class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        final int size = numbers.length;
        final Map<Integer, Integer> numToIndexMap = new HashMap<>(size);
        for (int i = 0; i < size; ++i) {
            final int number = numbers[i];
            final int key = target - number;
            final Integer possibleMatch = numToIndexMap.get(key);
            if (possibleMatch != null) {
                return new int[]{
                        Math.min(i, possibleMatch),
                        Math.max(i, possibleMatch)
                };
            }
            numToIndexMap.put(number, i);
        }
        return null;
    }

}
