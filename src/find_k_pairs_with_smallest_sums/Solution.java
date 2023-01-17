package find_k_pairs_with_smallest_sums;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int p1 = 0, p2 = 0;
        int pm1 = -1, pm2 = -1;
        for (int i = 0; i < k; i++) {
            result.add(List.of(nums1[p1], nums2[p2]));
            int sum = nums1[p1] + nums2[p2];
            if (p1 == nums1.length - 1 && p2 == nums2.length - 1) {
                break;
            }
            if (p1 == nums1.length - 1) pm2 = p2;
            if (p2 == nums2.length - 1) pm1 = p1;
            // Next step
            // 1. p1+1, p2 back as possible
            int c2p1 = p1, c1p2 = p2;
            int c1sum = Integer.MAX_VALUE;
            if (p1 + 1 < nums1.length) {
                c1sum = sum;
                c1sum += nums1[p1 + 1] - nums1[p1];
                while (c1sum >= sum && c1p2 > pm2 && c1p2 > 0) {
                    c1sum -= nums2[c1p2];
                    c1p2--;
                    c1sum += nums2[c1p2];
                }
                if (c1sum < sum || c1p2 == pm2) c1p2++;
            }

            // 2. p2+1, p1 back as possible
            int c2sum = Integer.MAX_VALUE;
            if (p2 + 1 < nums2.length) {
                c2sum = sum;
                c2sum += nums2[p2 + 1] - nums2[p2];
                while (c2sum >= sum && c2p1 > pm1 && c2p1 > 0) {
                    c2sum -= nums1[c2p1];
                    c2p1--;
                    c2sum += nums1[c2p1];
                }
                if (c2sum < sum || c2p1 == pm1) c2p1++;
            }

            if (c1sum <= c2sum) {
                p1++;
                p2 = c1p2;
            } else {
                p2++;
                p1 = c2p1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
//        System.out.println(new Solution().kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
//        System.out.println(new Solution().kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10));
//        System.out.println(new Solution().kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));
//        System.out.println(new Solution().kSmallestPairs(new int[]{1, 7, 9}, new int[]{1, 5, 11}, 10));
        System.out.println(new Solution().kSmallestPairs(new int[]{1, 2, 4}, new int[]{-1, 1, 2}, 10));
    }
}
