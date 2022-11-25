package search_2d_matrix_2;

import java.util.Arrays;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int xl = matrix.length;
        int yl = matrix[0].length;
        if (matrix[0][0] > target || matrix[xl - 1][yl - 1] < target) {
            return false;
        }

        int sx = 0, ex = xl;
        while (true) {
            if (sx == ex - 1 || sx == ex) {
                break;
            }
            int mx = (sx + ex) / 2;
            if (matrix[mx][0] == target) {
                return true;
            } else if (matrix[mx][0] > target) {
                ex = mx;
            } else {
                sx = mx ;
            }
        }
        if (matrix[sx][0] == target) {
            return true;
        }
        int startmax = sx;

        sx = 0;
        ex = xl;
        while (true) {
            if (sx == ex - 1 || sx == ex) {
                break;
            }
            int mx = (sx + ex) / 2;
            if (matrix[mx][yl - 1] == target) {
                return true;
            } else if (matrix[mx][yl - 1] > target) {
                ex = mx;
            } else {
                sx = mx ;
            }
        }
        if (matrix[sx][yl - 1] == target) {
            return true;
        }
        int endmin = sx + 1;
        for (int x = endmin; x <= startmax; x++) {
            if (Arrays.binarySearch(matrix[x], target) >=0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().searchMatrix(new int[][]{
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        }, 20));
//        System.out.println(new Solution().searchMatrix(new int[][]{
//                {1}, {2}, {3}, {4}, {5} }, 2));
        System.out.println(new Solution().searchMatrix(new int[][]{
                {1, 3, 5}}, 3));
    }
}
