package paint_fence;

import java.util.Arrays;

public class Solution {
    public int numWays(int n, int k) {
        int[][] buffer = new int[k][2];
        for (int i = 0; i < k; i++) {
            buffer[i] = new int[]{1, 0};
        }
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum = 0;
            for (int j = 0; j < k; j++) {
                sum += buffer[j][0];
                sum += buffer[j][1];
            }
            for (int j = 0; j < k; j++) {
                int old0 = buffer[j][0];
                int old1 = buffer[j][1];
                buffer[j] = new int[]{sum - old0 - old1, old0};

            }
        }
        sum = 0;
        for (int j = 0; j < k; j++) {
            sum += buffer[j][0];
            sum += buffer[j][1];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numWays(3, 2));
    }
}
