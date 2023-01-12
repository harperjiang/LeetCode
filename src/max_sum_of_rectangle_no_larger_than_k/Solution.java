package max_sum_of_rectangle_no_larger_than_k;

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cumsum = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                cumsum[i][j] = cumsum[i - 1][j] + cumsum[i][j - 1] - cumsum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int i1 = 0; i1 < i; i1++) {
                    for (int j1 = 0; j1 < j; j1++) {
                        int sum = cumsum[i][j] - cumsum[i1][j] - cumsum[i][j1] + cumsum[i1][j1];
                        if (sum <= k) {
                            max = Math.max(max, sum);
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSumSubmatrix(new int[][]{
                {1, 0, 1}, {0, -2, 3}
        }, 2));
    }
}
