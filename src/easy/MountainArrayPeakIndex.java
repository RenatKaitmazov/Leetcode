package easy;

/**
 * Let's call an array A a mountain if the following properties hold:
 * • A.length >= 3
 * • There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain,
 * return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 *
 * @author Renat Kaitmazov
 */

public final class MountainArrayPeakIndex {

    public int peakIndexInMountainArray(int[] numbers) {
        final int start = 0, end = numbers.length - 1;
        int left = start, right = end;
        while (left <= right) {
            final int guess = left + ((right - left) >> 1);
            if (guess == start || guess == end) return guess;
            if      (inLeftPart(numbers, guess)) left = guess + 1;
            else if (inRightPart(numbers, guess)) right = guess - 1;
            else return guess;
        }
        return -1;
    }

    private boolean inLeftPart(int[] numbers, int guess) {
        return numbers[guess - 1] < numbers[guess] && numbers[guess] < numbers[guess + 1];
    }

    private boolean inRightPart(int[] numbers, int guess) {
        return numbers[guess - 1] > numbers[guess] && numbers[guess] > numbers[guess + 1];
    }
}
