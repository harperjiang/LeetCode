package paint_house;

/**
 * DFS search
 */
public class Solution {

    int dfs(int[][] buffer, int[][] costs, int pos, int prev) {
        if (pos == costs.length) {
            return 0;
        }
        if (prev >= 0 && buffer[pos][prev] != -1) {
            return buffer[pos][prev];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; ++i) {
            if (i != prev) {
                min = Math.min(min, costs[pos][i] + dfs(buffer, costs, pos + 1, i));
            }
        }
        if (prev >= 0) {
            buffer[pos][prev] = min;
        }
        return min;
    }

    public int minCost(int[][] costs) {
        int[][] buffer = new int[costs.length][];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = new int[]{-1, -1, -1};
        }
        buffer[buffer.length - 1][0] = Math.min(costs[buffer.length - 1][1], costs[buffer.length - 1][2]);
        buffer[buffer.length - 1][1] = Math.min(costs[buffer.length - 1][0], costs[buffer.length - 1][2]);
        buffer[buffer.length - 1][2] = Math.min(costs[buffer.length - 1][0], costs[buffer.length - 1][1]);
        return dfs(buffer, costs, 0, -1);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().minCost(new int[][]{
//                {17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
        System.out.println(new Solution().minCost(new int[][]{{7, 6, 2}}));
    }
}
