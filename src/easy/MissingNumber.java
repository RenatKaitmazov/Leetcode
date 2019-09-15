package easy;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 *
 * @author Renat Kaitmazov
 */

public final class MissingNumber {

    public int missingNumber(int[] nums) {
        final int size = nums.length;
        final int expectedSum = (size * (size + 1)) >> 1;
        final int actualSum = sum(nums, size);
        return expectedSum - actualSum;
    }

    private int sum(int[] arr, int size) {
        int sum = arr[0];
        for (int i = 1; i < size; ++i) {
            sum += arr[i];
        }
        return sum;
    }
}
