package find_smallest_common_elements_in_all_rows;

import java.util.Arrays;

public class Solution {
    public int smallestCommonElement(int[][] mat) {
        int width = mat[0].length;
        int height = mat.length;
        int lb = mat[0][0];
        int ub = mat[0][width - 1];
        int lp = 0;
        int rp = width;
        boolean[] mark = new boolean[width];
        Arrays.fill(mark, true);
        int[] base = mat[0];

        for (int i = 1; i < height; ++i) {
            int[] row = mat[i];
            int nlb = Math.max(lb, row[0]);
            ub = Math.min(ub, row[width - 1]);
            if (nlb != lb) {
                // Update lp
                int nlp = Arrays.binarySearch(base, lp, width, nlb);
                if (nlp >= 0) {
                    lp = nlp;
                } else {
                    lp = -nlp - 1;
                }
                while (lp < width && !mark[lp]) lp++;
                if (lp == width) {
                    return -1;
                }
            }
            // Check if all numbers exists
            for (int j = lp; j < width; j++) {
                if (base[j] > ub) {
                    break;
                }
                if (!mark[j]) {
                    continue;
                }
                mark[j] = Arrays.binarySearch(row, 0, width, base[j]) >= 0;
            }
        }
        for (int i = lp; i < width; ++i) {
            if (mark[i]) {
                return base[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().smallestCommonElement(
                new int[][]{
                        new int[]{1, 2, 3, 4, 5},
                        new int[]{2, 4, 5, 8, 10},
                        new int[]{3, 5, 7, 9, 11},
                        new int[]{1, 3, 5, 7, 9}
                }));
        System.out.println(new Solution().smallestCommonElement(
                new int[][]{
                        new int[]{1, 2, 3},
                        new int[]{2, 3, 4},
                        new int[]{2, 3, 5}
                }));
    }
}
