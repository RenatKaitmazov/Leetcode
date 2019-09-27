package easy;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * @author Renat Kaitmazov
 */

public final class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        final int size = nums.length;
        final int[] sumArray = new int[size];
        final int firstNum = nums[0];
        sumArray[0] = firstNum;
        int max = firstNum;
        for (int i = 1; i < size; ++i) {
            final int currentNum = nums[i];
            final int newMax = Math.max(currentNum + sumArray[i - 1], currentNum);
            sumArray[i] = newMax;
            if (newMax > max) {
                max = newMax;
            }
        }
        return max;
    }
}
