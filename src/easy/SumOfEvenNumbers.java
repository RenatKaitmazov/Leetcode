package easy;

import java.util.Arrays;

/**
 * We have an array A of integers, and an array queries of queries.
 * For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].
 * Then, the answer to the i-th query is the sum of the even values of A.
 * (Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A)
 * Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
 * Note:
 * • 1 <= A.length <= 10000
 * • -10000 <= A[i] <= 10000
 * • 1 <= queries.length <= 10000
 * • -10000 <= queries[i][0] <= 10000
 * • 0 <= queries[i][1] < A.length
 *
 * @author Renat Kaitmazov
 */

public final class SumOfEvenNumbers {

    public int[] sumEvenAfterQueries(int[] numbers, int[][] queries) {
        final int numbersSize = numbers.length;
        int totalEvenNumsSum = evenNumsSum(numbers, numbersSize);
        final int queriesSize = queries.length;
        final int[] results = new int[queriesSize];
        for (int q = 0; q < queriesSize; ++q) {
            final int[] query = queries[q];
            final int value = query[0];
            final int index = query[1];
            final int number = numbers[index];
            final int newNumber = value + number;
            if (number % 2 == 0) {
                if (value % 2 == 0) {
                    // Even number + even number = even number
                    totalEvenNumsSum += value;
                } else {
                    // Even number + odd number = odd number
                    totalEvenNumsSum -= number;
                }
            } else {
                if (value % 2 != 0) {
                    // Odd number + odd number = even number
                    totalEvenNumsSum += newNumber;
                }
            }
            numbers[index] = newNumber;
            results[q] = totalEvenNumsSum;
        }
        return results;
    }

    private int evenNumsSum(int[] numbers, int size) {
        int sum = 0;
        for (int i = 0; i < size; ++i) {
            final int num = numbers[i];
            if (num % 2 == 0) {
                sum += num;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new SumOfEvenNumbers().sumEvenAfterQueries(
                                new int[]{1, 2, 3, 4},
                                new int[][] {
                                        {1, 0},
                                        {-3, 1},
                                        {-4, 0},
                                        {2, 3}
                                }
                        )
                )
        );
    }
}
