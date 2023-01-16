package range_addition;

import java.util.*;

public class Solution {


    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        result[0] = 0;
        result[result.length - 1] = 0;
        for (int[] b : updates) {
            result[b[0]] += b[2];
            if (b[1] + 1 < result.length)
                result[b[1] + 1] -= b[2];
        }
        int current = result[0];
        for (int i = 1; i < result.length; i++) {
            current += result[i];
            result[i] = current;
        }
        return result;
    }

    public static void main(String[] args) {
//        new Solution().getModifiedArray(100, new int[][]{
//                {4, 7, 5}, {4, 10, 6}, {5, 10, 3}, {12, 15, 1}
//        });
        new Solution().getModifiedArray(5, new int[][]{
                {1, 3, 2}, {2, 4, 3}, {0, 2, -2}
        });
        new Solution().getModifiedArray(10, new int[][]{
                {2, 4, 6}, {5, 6, 8}, {1, 9, -4}
        });
    }
}
