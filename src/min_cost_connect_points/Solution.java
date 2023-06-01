package min_cost_connect_points;

import java.util.Arrays;

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int[] cost = new int[points.length];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;
        for (int i = 1; i < points.length; i++) {
            int[] pi = points[i];
            int from = -1;
            for (int j = 0; j < i; j++) {
                int[] pj = points[j];
                int dij = Math.abs(pi[0] - pj[0]) + Math.abs(pi[1] - pj[1]);
                if(dij < cost[i]) {
                    cost[i] = dij;
                    from = j;
                }
            }
            for (int j = 0; j < i; j++) {
                if(j != from) {
                    int[] pj = points[j];
                    int dij = Math.abs(pi[0] - pj[0]) + Math.abs(pi[1] - pj[1]);
                    cost[j] = Math.min(cost[j], dij);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < cost.length; i++) {
            sum += cost[i];
        }
        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
        System.out.println(new Solution().minCostConnectPoints(new int[][]{{-14, -14}, {-18, 5}, {18, -10}, {18, 18}, {10, -2}}));
//       [-14,-14],[-18,5],[18,-10],[18,18],[10,-2]
    }
}
