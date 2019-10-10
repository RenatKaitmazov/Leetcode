package medium;

/**
 * Given a square array of integers A, we want the minimum sum of a falling path through A.
 *
 * A falling path starts at any element in the first row, and chooses one element from each row.
 * The next row's choice must be in a column that is different from the previous row's column by at most one.
 *
 * @author Renat Kaitmazov
 */

public final class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] grid) {
        final int size = grid.length;
        for (int r = 1; r < size; ++r) {
            final int[] row = grid[r];
            final int[] prevRow = grid[r - 1];
            final int firstValue = row[0];
            int min = firstValue + prevRow[0];
            int second = firstValue + prevRow[1];
            if (second < min) min = second;
            row[0] = min;
            final int lastValue = row[size - 1];
            min = lastValue + prevRow[size - 1];
            second = lastValue + prevRow[size - 2];
            if (second < min) min = second;
            row[size - 1] = min;
            for (int c = 1; c < size - 1; ++c) {
                final int value = row[c];
                min = value + prevRow[c - 1];
                second = value + prevRow[c];
                if (second < min) min = second;
                second = value + prevRow[c + 1];
                if (second < min) min = second;
                row[c] = min;
            }
        }
        final int[] lastRow = grid[size - 1];
        int min = lastRow[0];
        for (int i = 1; i < size; ++i) {
            final int value = lastRow[i];
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}
