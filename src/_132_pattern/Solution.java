package _132_pattern;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution {
    public boolean find132pattern(int[] nums) {
        TreeMap<Integer, Integer> intervals = new TreeMap<>();
        int[] buffer = new int[3];
        buffer[0] = nums[0];
        int bp = 0;
        for (int i = 1; i < nums.length; i++) {
            for (Map.Entry<Integer, Integer> e : intervals.headMap(nums[i]).entrySet()) {
                if (e.getValue() > nums[i]) return true;
            }
            if (bp == 1 && nums[i] > buffer[0] && nums[i] < buffer[1]) return true;

            switch (bp) {
                case 0:
                    if (nums[i] < buffer[0]) buffer[0] = nums[i];
                    if (nums[i] > buffer[0]) {
                        buffer[1] = nums[i];
                        bp = 1;
                    }
                    break;
                case 1:
                    if (nums[i] > buffer[1]) {
                        buffer[1] = nums[i];
                    }
                    if (nums[i] < buffer[0]) {
                        // TODO merge the intervals, only possible to cover some existing intervals
                        Set<Integer> toremove = new HashSet<>();
                        for (Map.Entry<Integer, Integer> e : intervals.subMap(buffer[0], buffer[1]).entrySet()) {
                            if (e.getValue() < buffer[1]) toremove.add(e.getKey());
                        }
                        for (Integer tr : toremove)
                            intervals.remove(tr);
                        intervals.put(buffer[0], buffer[1]);
                        bp = 0;
                        buffer[0] = nums[i];
                    }
                    break;
                default:
                    break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().find132pattern(new int[]{3, 1, 4, 2}));
    }
}
