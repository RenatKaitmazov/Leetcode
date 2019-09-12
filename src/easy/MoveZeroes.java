package easy;

/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 * Note:
 * • You must do this in-place without making a copy of the array.
 * • Minimize the total number of operations.
 *
 * @author Renat Kaitmazov
 */

public final class MoveZeroes {

    public void moveZeroes(int[] nums) {
        final int size = nums.length;
        int zeroIndex = 0;
        while (zeroIndex < size && nums[zeroIndex] != 0) {
            ++zeroIndex;
        }
        for (int i = zeroIndex + 1; i < size; ++i) {
            if (nums[i] == 0) {
                continue;
            }
            swap(nums, zeroIndex, i);
            ++zeroIndex;
        }
    }

    private void swap(int[] arr, int i, int j) {
        final int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
