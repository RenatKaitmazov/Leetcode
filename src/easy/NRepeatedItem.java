package easy;

/**
 * In a array A of size 2N, there are N+1 unique elements,
 * and exactly one of these elements is repeated N times.
 * Return the element repeated N times.
 *
 * @author Renat Kaitmazov
 */

public final class NRepeatedItem {

    public int repeatedNTimes(int[] numbers) {
        final int size = numbers.length;
        for (int i = 2; i < size; ++i) {
            final int one = numbers[i - 2];
            final int two = numbers[i - 1];
            final int three = numbers[i];
            if (one == two) return one;
            if (two == three) return two;
            if (three == one) return three;
        }
        return numbers[0];
    }
}
