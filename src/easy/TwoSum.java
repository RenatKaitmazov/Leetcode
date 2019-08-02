package easy;

import java.util.Arrays;

/**
 * Given an array of integers, return indices of the two numbers such that
 * they add up to a specific target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * @author Renat Kaitmazov
 */

public final class TwoSum {

    private static final int NO_INDEX = -1;

    public int[] twoSum(int[] numbers, int target) {
        final int size = numbers.length;
        final Pair[] pairs = new Pair[size];
        for (int i = 0; i < size; ++i) {
            final int value = numbers[i];
            pairs[i] = new Pair(i, value);
        }
        Arrays.sort(pairs);
        for (int i = 0; i < size; ++i) {
            final Pair pair = pairs[i];
            final int value = pair.value;
            final int key = target - value;
            final int possibleMathIndex = bs(pairs, key, i + 1, size);
            if (possibleMathIndex != NO_INDEX) {
                final Pair matchedPair = pairs[possibleMathIndex];
                return new int[]{
                        pair.index,
                        matchedPair.index
                };
            }
        }
        return null;
    }

    private int bs(Pair[] array, int key, int from, int to) {
        int s = from;
        int e = to - 1;
        while (s <= e) {
            final int middle = s + ((e - s) >> 1);
            final int guess = array[middle].value;
            if      (guess < key) s = middle + 1;
            else if (guess > key) e = middle - 1;
            else return middle;
        }
        return NO_INDEX;
    }

    private static final class Pair implements Comparable<Pair> {
        private final int index;
        private final int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair that) {
            if (this.value < that.value) return -1;
            if (this.value > that.value) return +1;
            if (this.index < that.value) return -1;
            if (this.index > that.index) return +1;
            return 0;
        }
    }
}
