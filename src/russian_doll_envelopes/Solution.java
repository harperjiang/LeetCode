package russian_doll_envelopes;

import java.util.*;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // First sort by width,
        // then build a topological sort
        // which can be solved using dynamic programming
        List<int[]> buffer = new ArrayList<>();
        for (int[] env : envelopes)
            buffer.add(new int[]{env[0], env[1], 0});

        Collections.sort(buffer, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });


        int max = 0;
        List<Integer> tracker = new ArrayList<>();

        for (int i = 0; i < buffer.size(); i++) {
            int[] val = buffer.get(i);
            if (tracker.isEmpty() || val[1] > tracker.get(tracker.size() - 1)) {
                tracker.add(val[1]);
                max = Math.max(tracker.size(), max);
            } else {
                // Find the first value larger or equal to val[2] and replace it
                int index = Collections.binarySearch(tracker, val[1]);
                if (index < 0) {
                    tracker.set(-index - 1, val[1]);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxEnvelopes(new int[][]{
                {4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}}));//4
        System.out.println(new Solution().maxEnvelopes(new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {3, 5}, {4, 5}, {5, 5}, {5, 6}, {6, 7}, {7, 8}
        }));//7
        System.out.println(new Solution().maxEnvelopes(new int[][]{
                {30, 50}, {12, 2}, {3, 4}, {12, 15}
        }));//3
        System.out.println(new Solution().maxEnvelopes(new int[][]{
                {4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}, {1, 1}
        }));//4
        System.out.println(new Solution().maxEnvelopes(new int[][]{
                {46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}
        }));//3
        System.out.println(new Solution().maxEnvelopes(new int[][]{
                {6, 10}, {11, 14}, {6, 1}, {16, 14}, {13, 2}
        }));//3
        System.out.println(new Solution().maxEnvelopes(new int[][]{
                {2, 1}, {4, 1}, {6, 2}, {8, 3}, {10, 5}, {12, 8}, {14, 13}, {16, 21}, {18, 34}, {20, 55}
        }));//9
        System.out.println(new Solution().maxEnvelopes(new int[][]{
                {7, 10}, {14, 7}, {3, 16}, {6, 3}, {7, 9}, {5, 2}, {10, 1}, {6, 11}, {18, 20}
        }));//4
        System.out.println(new Solution().maxEnvelopes(new int[][]{
                {16, 1}, {6, 9}, {16, 12}, {8, 7}, {18, 16}, {8, 10}, {13, 19}, {16, 7}, {7, 20}, {13, 6}, {9, 11}, {10, 13}, {15, 19}, {8, 11}
        }));//5
    }
}
