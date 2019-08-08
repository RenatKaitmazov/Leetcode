package easy;

/**
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 * Return the minimum number of students not standing in the right positions.
 * (This is the number of students that must move in order for all students
 * to be standing in non-decreasing order of height.)
 * Note:
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 *
 * @author Renat Kaitmazov
 */

public final class HeightChecker {

    private static final int MAX_VALUE = 100;

    public int heightChecker(int[] heights) {
        final int[] bucket = new int[MAX_VALUE + 1];
        final int size = heights.length;
        for (int i = 0; i < size; ++i) {
            final int height = heights[i];
            // Since the maximum possible value is not greater than 100, we can count
            // their occurrences in the array.
            ++bucket[height];
        }
        int displacements = 0;
        for (int num = 1, k = 0; num <= MAX_VALUE; ++num) {
            final int count = bucket[num];
            for (int j = 0; j < count; ++j) {
                // And then check how many numbers are out of order.
                if (heights[k++] != num) {
                    ++displacements;
                }
            }
        }
        return displacements;
    }
}
