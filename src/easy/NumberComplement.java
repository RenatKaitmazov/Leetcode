package easy;

/**
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 * Note:
 * • The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * • You could assume no leading zero bit in the integer’s binary representation.
 *
 * @author Renat Kaitmazov
 */

public final class NumberComplement {

    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }
        final int mask = (1 << bitLength(num)) - 1;
        return mask ^ num;
    }

    private int bitLength(int ofNum) {
        int length = 0;
        while (ofNum > 0) {
            ++length;
            ofNum >>= 1;
        }
        return length;
    }
}
