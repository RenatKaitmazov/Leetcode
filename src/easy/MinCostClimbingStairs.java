package easy;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps.
 * You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0,
 * or the step with index 1.
 * <p>
 * Note:
 * • Cost will have a length in the range [2, 1000].
 * • Every cost[i] will be an integer in the range [0, 999].
 *
 * @author Renat Kaitmazov
 */

public final class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        final int size = cost.length;
        final int upperBound = size - 1;
        int previousMin = 0;
        int currentMin = 0;
        for (int i = 0; i < upperBound; ++i) {
            final int currentCost = cost[i];
            final int tempPreviousMin = previousMin;
            previousMin = currentMin;
            currentMin = Math.min(
                    currentCost + tempPreviousMin,
                    currentCost + currentMin
            );
        }
        return Math.min(currentMin, previousMin + cost[upperBound]);
    }
}
