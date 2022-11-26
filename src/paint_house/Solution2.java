package paint_house;

/**
 * DP
 */
public class Solution2 {

    public int minCost(int[][] costs) {
        int[] buffer = new int[3];
        buffer[0] = costs[0][0];
        buffer[1] = costs[0][1];
        buffer[2] = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int[] newbuffer = new int[3];
            newbuffer[0] = costs[i][0] + Math.min(buffer[1], buffer[2]);
            newbuffer[1] = costs[i][1] + Math.min(buffer[0], buffer[2]);
            newbuffer[2] = costs[i][2] + Math.min(buffer[0], buffer[1]);
            buffer = newbuffer;
        }
        return Math.min(Math.min(buffer[0], buffer[1]), buffer[2]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minCost(new int[][]{
                {17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
        System.out.println(new Solution2().minCost(new int[][]{{7, 6, 2}}));
    }
}
