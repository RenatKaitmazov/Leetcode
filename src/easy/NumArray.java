package easy;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Note:
 * • You may assume that the array does not change.
 * • There are many calls to sumRange function.
 *
 * @author Renat Kaitmazov
 */

public final class NumArray {

    private final int[] prefixSum;

    public NumArray(int[] nums) {
        final int size = nums.length;
        prefixSum = new int[size];
        if (size > 0) {
            prefixSum[0] = nums[0];
            for (int i = 1; i < size; ++i) {
                prefixSum[i] = nums[i] + prefixSum[i - 1];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i > 0) {
            return prefixSum[j] - prefixSum[i - 1];
        }
        return prefixSum[j];
    }
}
