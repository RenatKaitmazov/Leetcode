package easy;

/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * To flip an image horizontally means that each row of the image is reversed.
 * For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 * For example, inverting [0, 1, 1] results in [1, 0, 0].
 *
 * @author Renat Kaitmazov
 */

public final class FlipImage {

    public int[][] flipAndInvertImage(int[][] matrix) {
        final int rowsCount = matrix.length;
        for (int rowIndex = 0; rowIndex < rowsCount; ++rowIndex) {
            final int[] row = matrix[rowIndex];
            for (int s = 0, e = row.length - 1; s <= e; ++s, --e) {
                final int sNumber = row[s];
                final int eNumber = row[e];
                if (sNumber == eNumber) {
                    row[s] = 1 - row[s];
                    if (s != e) {
                        row[e] = 1 - row[e];
                    }
                }
            }
        }
        return matrix;
    }
}
