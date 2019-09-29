package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * <p>
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 * @author Renat Kaitmazov
 */

public final class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        final int size = nums.length;
        final Set<Integer> set = new HashSet<>(size);
        for (int i = 0; i < size; ++i) {
            final int number = nums[i];
            if (set.contains(number)) {
                return true;
            }
            set.add(number);
        }
        return false;
    }
}
