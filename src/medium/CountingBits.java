package medium;

/**
 * Given a non negative integer number num.
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation
 * and return them as an array.
 * Follow up:
 * <p>
 * • It is very easy to come up with a solution with run time O(n*sizeof(integer)).
 * But can you do it in linear time O(n) /possibly in a single pass?
 * • Space complexity should be O(n).
 * • Can you do it like a boss? Do it without using any builtin function
 * like __builtin_popcount in c++ or in any other language.
 *
 * @author Renat Kaitmazov
 */

public final class CountingBits {

    public int[] countBits(int num) {
        final int[] bits = new int[num + 1];
        if (num > 0) {
            bits[1] = 1;
            for (int i = 2, prevPowerOfTwo = 1; i <= num; ++i) {
                if (i == prevPowerOfTwo << 1) {
                    bits[i] = 1;
                    prevPowerOfTwo = i;
                    continue;
                }
                final int diff = i - prevPowerOfTwo;
                bits[i] = bits[prevPowerOfTwo] + bits[diff];
            }
        }
        return bits;
    }
}
