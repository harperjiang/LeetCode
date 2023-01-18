package find_k_pairs_with_smallest_sums;

import java.text.MessageFormat;
import java.util.*;

public class Solution {

    long convert(int[] value) {
        return (((long) value[0]) << 32) + value[1];
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        TreeSet<Long> visited = new TreeSet<>();
        PriorityQueue<int[]> search = new PriorityQueue<>(Comparator.comparing((int[] i) -> i[2]));
        search.add(new int[]{0, 0, nums1[0] + nums2[0]});
        visited.add(0L);
        for (int i = 0; i < k; i++) {
            if (search.isEmpty()) break;
            int[] check = search.poll();
            result.add(List.of(nums1[check[0]], nums2[check[1]]));
            if (check[0] + 1 < nums1.length && check[0] < k) {
                int[] next = new int[]{check[0] + 1, check[1], nums1[check[0] + 1] + nums2[check[1]]};
                long state = convert(next);
                if (!visited.contains(state)) {
                    search.add(next);
                    visited.add(state);
                }
            }
            if (check[1] + 1 < nums2.length && check[1] < k) {
                int[] next = new int[]{check[0], check[1] + 1, nums1[check[0]] + nums2[check[1] + 1]};
                long state = convert(next);
                if (!visited.contains(state)) {
                    search.add(next);
                    visited.add(state);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
//        System.out.println(new Solution().kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
        System.out.println(new Solution().kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10));
//        System.out.println(new Solution().kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));
//        System.out.println(new Solution().kSmallestPairs(new int[]{1, 7, 9}, new int[]{1, 5, 11}, 10));
//        System.out.println(new Solution().kSmallestPairs(new int[]{1, 2, 4}, new int[]{-1, 1, 2}, 10));
    }
}
