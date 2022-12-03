package perfect_squares;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    int dfs(int remain, int[] buffer) {
        if (remain == 0) {
            return 0;
        }
        if (buffer[remain] != 0) {
            return buffer[remain];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= remain; i++) {
            min = Math.min(1 + dfs(remain - i * i, buffer), min);
        }
        buffer[remain] = min;
        return min;
    }

    public int numSquares(int n) {
        int[] buffer = new int[n+1];
        return dfs(n, buffer);
    }

}
