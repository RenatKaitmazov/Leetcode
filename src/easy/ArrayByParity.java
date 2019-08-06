package easy;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 *
 * @author Renat Kaitmazov
 */

public final class ArrayByParity {

    public int[] sortArrayByParity(int[] numbers) {
        int s = 0;
        int e = numbers.length - 1;
        while (s < e) {
            // Move to the left until an odd number is found or the array is exhausted.
            if (numbers[s] % 2 == 0) {
                ++s;
                continue;
            }
            // The number on the left is even but the number on the right is odd.
            // Exchange them and move pointers towards each other.
            if (numbers[e] % 2 == 0) {
                swap(numbers, s++, e--);
                continue;
            }
            // Both numbers are odd. Move the number of the left to the end and move the end
            // pointer toward the start.
            swap(numbers, s, e--);
        }
        return numbers;
    }

    private void swap(int[] array, int i, int j) {
        final int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
