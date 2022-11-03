package rotate_image;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 0,0 -> 0,n-1
 * 0,1 -> 1,n-1
 * 0,2 -> 2,n-1
 * 1,0 -> 0,1
 * 1,1 -> 1,1
 * 1,2 -> 2,1
 * 2,0 -> 0,0
 * 2,1 -> 1,0
 * 2,2 -> 2,0
 */
public class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = i; j < matrix.length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            for (int j = 0; j < matrix.length / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    public void crotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = i; j < matrix.length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            for (int j = 0; j < matrix.length / 2; ++j) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{5, 1, 9, 11},
                new int[]{2, 4, 8, 10},
                new int[]{13, 3, 6, 7},
                new int[]{15, 14, 12, 16}
        };
        System.out.println(Arrays.stream(matrix)
                .map(i -> Arrays.stream(i).mapToObj(k -> String.valueOf(k)).collect(Collectors.joining(",")))
                .collect(Collectors.joining("\n")));

        new Solution().rotate(matrix);

        System.out.println(Arrays.stream(matrix)
                .map(i -> Arrays.stream(i).mapToObj(k -> String.valueOf(k)).collect(Collectors.joining(",")))
                .collect(Collectors.joining("\n")));

        new Solution().crotate(matrix);

        System.out.println(Arrays.stream(matrix)
                .map(i -> Arrays.stream(i).mapToObj(k -> String.valueOf(k)).collect(Collectors.joining(",")))
                .collect(Collectors.joining("\n")));
    }
}
