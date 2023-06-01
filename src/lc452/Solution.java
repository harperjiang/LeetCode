package lc452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparing((int[] x) -> x[0]).thenComparing((int[]x)->x[1]));

        int i = 0;
        int counter = 0;
        while (i < points.length) {
            int iend = points[i][1];
            int j = i + 1;
            while (j < points.length && points[j][0] <= iend) {
                iend = Math.min(iend,points[j][1]);
                j++;
            }
            counter++;
            i = j;
        }
        return counter;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().findMinArrowShots(new int[][]{
//                {3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}
//        }));
        System.out.println(new Solution().findMinArrowShots(new int[][]{
                {9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}
        }));
    }
}
