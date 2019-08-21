package medium;

/**
 * Given an array of integers nums, sort the array in ascending order.
 * Note:
 * • 1 <= A.length <= 10000
 * • -50000 <= A[i] <= 50000
 *
 * @author Renat Kaitmazov
 */

public final class SortArray {

    public int[] sortArray(int[] nums) {
        final int size = nums.length;
        final int[] aux = new int[size];
        sort(nums, aux, 0, size - 1);
        return nums;
    }

    private void sort(int[] nums, int[] aux, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        final int middle = startIndex + ((endIndex - startIndex) >> 1);
        sort(nums, aux, startIndex, middle);
        sort(nums, aux, middle + 1, endIndex);
        merge(nums, aux, startIndex, middle, endIndex);
    }

    private void merge(int[] nums, int[] aux, int start, int middle, int end) {
        if (nums[middle] < nums[middle + 1]) {
            return;
        }
        System.arraycopy(nums, start, aux, start, end - start + 1);
        for (int k = start, l = start, r = middle + 1; k <= end; ++k) {
            if (l > middle) nums[k] = aux[r++];
            else if (r > end) nums[k] = aux[l++];
            else if (aux[r] < aux[l]) nums[k] = aux[r++];
            else nums[k] = aux[l++];
        }
    }
}
