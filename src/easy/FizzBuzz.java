package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 * @author Renat Kaitmazov
 */

public final class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        final List<String> numbers = new ArrayList<>(n);
        for (int i = 1; i <= n; ++i) {
            final boolean divisibleByThree = i % 3 == 0;
            final boolean divisibleByFive = i % 5 == 0;
            final String answer;
            if      (divisibleByThree && divisibleByFive)   answer = "FizzBuzz";
            else if (divisibleByThree)                      answer = "Fizz";
            else if (divisibleByFive)                       answer = "Buzz";
            else                                            answer = String.valueOf(i);
            numbers.add(answer);
        }
        return numbers;
    }
}
