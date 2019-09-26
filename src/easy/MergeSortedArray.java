package easy;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * • The number of elements initialized in nums1 and nums2 are m and n respectively.
 * • You may assume that nums1 has enough space
 * (size that is greater or equal to m + n) to hold additional elements from nums2.
 *
 * @author Renat Kaitmazov
 */

public final class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        // Small optimization
        if (m == 0 || nums1[m - 1] <= nums2[0]) {
            System.arraycopy(nums2, 0, nums1, m, n);
            return;
        }
        final int size = m + n;
        // Auxiliary array
        final int[] aux = new int[size];
        System.arraycopy(nums1, 0, aux, 0, m);
        System.arraycopy(nums2, 0, aux, m, n);
        for (int k = 0, i = 0, j = m; k < size; ++k) {
            if      (i == m)            nums1[k] = aux[j++];
            else if (j == size)         nums1[k] = aux[i++];
            else if (aux[j] < aux[i])   nums1[k] = aux[j++];
            else                        nums1[k] = aux[i++];
        }
    }
}
