package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * • The solution set must not contain duplicate triplets.
 *
 * @author Renat Kaitmazov
 */

public final class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        final LinkedHashSet<List<Integer>> set = new LinkedHashSet<>();
        Arrays.sort(nums);
        final int size = nums.length;
        for (int i = 0; i < size; ++i) {
            final int first = nums[i];
            for (int j = i + 1; j < size; ++j) {
                final int second = nums[j];
                final int diff = -(first + second);
                if (Arrays.binarySearch(nums, j + 1, size, diff) > -1) {
                    final List<Integer> triplet = new ArrayList<>(3);
                    triplet.add(first);
                    triplet.add(second);
                    triplet.add(diff);
                    set.add(triplet);
                }
            }
        }
        final List<List<Integer>> triplets = new ArrayList<>(set.size());
        triplets.addAll(set);
        return triplets;
    }

    public static void main(String[] args) {
        new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
