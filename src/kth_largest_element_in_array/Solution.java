package kth_largest_element_in_array;

import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        TreeMap<Integer, Integer> t = new TreeMap<>();
        int counter = 0;
        for (int num : nums) {
            t.compute(num, (n, ov) -> ov == null ? 1 : ov + 1);
            counter++;
            if (counter > k) {
                int min = t.firstKey();
                int remain = t.firstEntry().getValue();

                if (remain == 1) {
                    t.pollFirstEntry();
                } else {
                    t.put(min, remain - 1);
                }
            }
        }
        return t.firstKey();
    }
}
