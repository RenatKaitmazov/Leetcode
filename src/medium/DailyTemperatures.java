package medium;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73],
 * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * Note:
 * The length of temperatures will be in the range [1, 30000].
 * Each temperature will be an integer in the range [30, 100].
 *
 * @author Renat Kaitmazov
 */

public final class DailyTemperatures {

    public int[] dailyTemperatures(int[] temps) {
        final Queue<Pair> visitedTemps = new PriorityQueue<>();
        visitedTemps.add(new Pair(temps[0], 0));
        final int size = temps.length;
        final int[] intervals = new int[size];
        for (int i = 1; i < size; ++i) {
            final int currentTemp = temps[i];
            while (!visitedTemps.isEmpty()) {
                final Pair pair = visitedTemps.peek();
                if (pair.value >= currentTemp) {
                    break;
                }
                intervals[pair.index] = i - pair.index;
                visitedTemps.remove();
            }
            visitedTemps.add(new Pair(currentTemp, i));
        }
        return intervals;
    }

    private static final class Pair implements Comparable<Pair> {
        private final int value;
        private final int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair that) {
            if (this.value < that.value) return -1;
            if (this.value > that.value) return +1;
            if (this.index < that.index) return -1;
            if (this.value > that.index) return +1;
            return 0;
        }
    }
}
