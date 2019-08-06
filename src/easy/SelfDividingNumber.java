package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * A self-dividing number is a number that is divisible by every digit it contains.
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * Given a lower and upper number bound, output a list of every possible self dividing number,
 * including the bounds if possible.
 *
 * @author Renat Kaitmazov
 */

public final class SelfDividingNumber {

    private static final int RADIX = 10;

    public List<Integer> selfDividingNumbers(int left, int right) {
        final List<Integer> selfDividingNumbers = new ArrayList<>();
        for (int numbers = left; numbers <= right; ++numbers) {
            if (isSelfDividing(numbers)) {
                selfDividingNumbers.add(numbers);
            }
        }
        return selfDividingNumbers;
    }

    private boolean isSelfDividing(int number) {
        if (number < 1) return false;
        int num = number;
        while (num != 0) {
            final int lastDigit = num % RADIX;
            if (lastDigit == 0 || number % lastDigit != 0) {
                return false;
            }
            num /= RADIX;
        }
        return true;
    }
}
