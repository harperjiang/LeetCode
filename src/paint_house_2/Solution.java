package paint_house_2;

public class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int[] buffer = new int[k];
        for (int i = 0; i < k; i++) {
            buffer[i] = costs[0][i];
        }
        int[] newbuffer = new int[k];
        for (int i = 1; i < n; ++i) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            int secmin = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                int newmin = Math.min(buffer[j], min);
                if (newmin == buffer[j]) {
                    minIndex = j;
                    secmin = min;
                    min = newmin;
                } else {
                    secmin = Math.min(buffer[j],secmin);
                }
            }

            for (int j = 0; j < k; j++) {
                newbuffer[j] = costs[i][j] + ((j == minIndex) ? secmin : min);
            }
            System.arraycopy(newbuffer, 0, buffer, 0, k);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            min = Math.min(buffer[i], min);
        }
        return min;
    }


}
