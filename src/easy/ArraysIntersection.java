package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Renat Kaitmazov
 */

public final class ArraysIntersection {

    public int[] intersect(int[] nums1, int[] nums2) {
        final int size1 = nums1.length;
        final int size2 = nums2.length;
        final int[] smaller = size1 < size2 ? nums1 : nums2;
        final int[] bigger = nums1 == smaller ? nums2 : nums1;
        final int smallerSize = size1 < size2 ? size1 : size2;
        final Map<Integer, Integer> counter = new HashMap<>(smallerSize);
        for (int i = 0; i < smallerSize; ++i) {
            final int key = smaller[i];
            final Integer count = counter.get(key);
            if (count == null) {
                counter.put(key, 1);
            } else {
                counter.put(key, count + 1);
            }
        }
        final int biggerSize = smallerSize == size1 ? size2 : size1;
        final List<Integer> intersection = new ArrayList<>();
        for (int i = 0; i < biggerSize; ++i) {
            final int key = bigger[i];
            final Integer count = counter.get(key);
            if (count == null) {
                continue;
            }
            intersection.add(key);
            if (count == 1) {
                counter.remove(key);
            } else {
                counter.put(key, count - 1);
            }
        }
        final int intersectionSize = intersection.size();
        final int[] newArray = new int[intersectionSize];
        for (int i = 0; i < intersectionSize; ++i) {
            newArray[i] = intersection.get(i);
        }
        return newArray;
    }
}
