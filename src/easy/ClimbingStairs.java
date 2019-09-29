package easy;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 *
 * @author Renat Kaitmazov
 */

public final class ClimbingStairs {

    public int climbStairs(int n) {
        int previous = 1;
        int current = 1;
        for (int i = 2; i <= n; ++i) {
            final int total = previous + current;
            previous = current;
            current = total;
        }
        return current;
    }
}
