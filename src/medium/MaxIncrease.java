package medium;

/**
 * In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there.
 * We are allowed to increase the height of any number of buildings,
 * by any amount (the amounts can be different for different buildings).
 * Height 0 is considered to be a building as well.
 * At the end, the "skyline" when viewed from all four directions of the grid,
 * i.e. top, bottom, left, and right, must be the same as the skyline of the original grid.
 * A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance.
 * What is the maximum total sum that the height of the buildings can be increased?
 *
 * @author Renat Kaitmazov
 */

public class MaxIncrease {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        final int rowsCount = grid.length;
        if (rowsCount < 1) {
            return 0;
        }
        final int colsCount = grid[0].length;
        final MaximizedGrid maximizedGrid = getMaximizedGrid(grid, rowsCount, colsCount);
        return maximizedGrid.countMaxDiff(grid, rowsCount, colsCount);
    }

    private MaximizedGrid getMaximizedGrid(int[][] fromGrid, int rowsCount, int colsCount) {
        final int[] maximizedRow = new int[rowsCount];
        for (int rowIndex = 0; rowIndex < rowsCount; ++rowIndex) {
            maximizedRow[rowIndex] = max(fromGrid[rowIndex], rowsCount);
        }
        final int[] maximizedCol = new int[colsCount];
        for (int colIndex = 0; colIndex < colsCount; ++colIndex) {
            int max = fromGrid[0][colIndex];
            for (int rowIndex = 1; rowIndex < rowsCount; ++rowIndex) {
                final int number = fromGrid[rowIndex][colIndex];
                if (number > max) {
                    max = number;
                }
            }
            maximizedCol[colIndex] = max;
        }
        return new MaximizedGrid(maximizedRow, maximizedCol);
    }

    private int max(int[] array, int size) {
        int max = array[0];
        for (int i = 1; i < size; ++i) {
            final int number = array[i];
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    private static final class MaximizedGrid {
        private final int[] maximizedRow;
        private final int[] maximizedCol;

        MaximizedGrid(int[] maximizedRow, int[] maximizedCol) {
            this.maximizedRow = maximizedRow;
            this.maximizedCol = maximizedCol;
        }

        int countMaxDiff(int[][] grid, int rowsCount, int colsCount) {
            int maxDiff = 0;
            for (int rowIndex = 0; rowIndex < rowsCount; ++rowIndex) {
                for (int colIndex = 0; colIndex < colsCount; ++colIndex) {
                    final int max = Math.min(maximizedRow[rowIndex], maximizedCol[colIndex]);
                    final int num = grid[rowIndex][colIndex];
                    maxDiff += (max - num);
                }
            }
            return maxDiff;
        }
    }
}
