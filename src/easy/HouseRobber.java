package easy;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing
 * each of them is that adjacent houses have security system connected and it will automatically contact
 * the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * @author Renat Kaitmazov
 */

public final class HouseRobber {

    public int rob(int[] nums) {
        final int size = nums.length;
        if (size == 0) {
            return 0;
        }
        final int first = nums[0];
        if (size == 1) {
            return first;
        }
        int firstMax = first;
        int secondMax = Math.max(firstMax, nums[1]);
        int max = Math.max(firstMax, secondMax);
        for (int i = 2; i < size; ++i) {
            max = Math.max(firstMax + nums[i], secondMax);
            firstMax = secondMax;
            secondMax = max;
        }
        return max;
    }
}
