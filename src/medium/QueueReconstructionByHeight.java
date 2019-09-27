package medium;

import java.util.Arrays;

/**
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k), where h is
 * the height of the person and k is the number of people in front of this person
 * who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * <p>
 * Note:
 * The number of people is less than 1,100.
 *
 * @author Renat Kaitmazov
 */

public final class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (lhs, rhs) -> {
            final int lhsHeight = lhs[0];
            final int rhsHeight = rhs[0];
            if (lhsHeight < rhsHeight) return +1;
            if (lhsHeight > rhsHeight) return -1;
            final int lhsPeopleInFront = lhs[1];
            final int rhsPeopleInFront = rhs[1];
            if (lhsPeopleInFront < rhsPeopleInFront) return -1;
            if (lhsPeopleInFront > rhsPeopleInFront) return +1;
            return 0;
        });
        final int size = people.length;
        for (int i = 1; i < size; ++i) {
            final int[] temp = people[i];
            final int lowerBound = i - (i - temp[1]);
            int j = i;
            for (; j > lowerBound; --j) {
                people[j] = people[j - 1];
            }
            if (j != i) {
                people[j] = temp;
            }
        }
        return people;
    }
}
