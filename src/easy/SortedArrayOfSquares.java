package easy;

import java.util.Arrays;

/**
 * Given an array of integers A sorted in non-decreasing order,
 * return an array of the squares of each number, also in sorted non-decreasing order.
 *
 * @author Renat Kaitmazov
 */

public final class SortedArrayOfSquares {

    public int[] sortedSquares(int[] numbers) {
        final int size = numbers.length;
        for (int i = 0; i < size; ++i) {
            final int number = numbers[i];
            numbers[i] = number * number;
        }
        Arrays.sort(numbers, 0, size);
        return numbers;
    }
}
