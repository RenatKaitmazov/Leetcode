package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 *
 * @author Renat Kaitmazov
 */

public final class NumbersDisappearedInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        final int size = nums.length;
        for (int i = 0; i < size; ) {
            final int expectedNumber = i + 1;
            final int actualNumber = nums[i];
            if (expectedNumber == actualNumber || nums[actualNumber - 1] == actualNumber) {
                ++i;
                continue;
            }
            swap(nums, i, actualNumber - 1);
        }
        final List<Integer> absentNumbers = new LinkedList<>();
        for (int i = 0; i < size; ++i) {
            final int expectedNumber = i + 1;
            if (nums[i] != expectedNumber) {
                absentNumbers.add(expectedNumber);
            }
        }
        return absentNumbers;
    }

    private void swap(int[] arr, int i, int j) {
        final int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
