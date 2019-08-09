package easy;

import java.util.Arrays;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 * @author Renat Kaitmazov
 */

public final class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        final int size = nums.length;
        int sum = nums[0];
        for (int i = 2; i < size; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
