package medium;

import java.util.ArrayList;
import java.util.Arrays;
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
        final List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        final int size = nums.length - 1;
        final int outerSize = size - 1;
        for (int i = 0; i < outerSize; ++i) {
            final int currentNum = nums[i];
            if (currentNum > 0) {
                break;
            }
            int s = i + 1;
            int e = size;
            while (s < e) {
                final int startNum = nums[s];
                final int endNum = nums[e];
                final int sum = currentNum + startNum + endNum;
                if (sum < 0) ++s;
                else if (sum > 0) --e;
                else {
                    if (i == 0 || nums[i - 1] != currentNum) {
                        final TripletList triplet = new TripletList(currentNum, startNum, endNum);
                        if (triplets.isEmpty() || !triplets.get(triplets.size() - 1).equals(triplet)) {
                            triplets.add(triplet);
                        }
                    }
                    ++s;
                    --e;
                }
            }
        }
        return triplets;
    }

    private static final class TripletList extends ArrayList<Integer> {

        TripletList(int first, int second, int third) {
            super(3);
            add(first);
            add(second);
            add(third);
        }
    }
}
