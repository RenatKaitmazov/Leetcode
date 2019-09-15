package easy;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊n/2⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * @author Renat Kaitmazov
 */

public final class MajorityElement {

    public int majorityElement(int[] nums) {
        int element = nums[0];
        int counter = 1;
        final int size = nums.length;
        for (int i = 1; i < size; ++i) {
            final int number = nums[i];
            if (counter == 0) {
                element = number;
                counter = 1;
                continue;
            }
            if (number == element) {
                ++counter;
            } else {
                --counter;
            }
        }
        return element;
    }
}
