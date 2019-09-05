package easy;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * @author Renat Kaitmazov
 */

public final class SingleNumber {

    public int singleNumber(int[] nums) {
        int singleNum = nums[0];
        final int size = nums.length;
        for (int i = 1; i < size; ++i) {
            singleNum ^= nums[i];
        }
        return singleNum;
    }
}
