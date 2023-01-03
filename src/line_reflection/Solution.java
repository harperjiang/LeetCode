package line_reflection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {
    public boolean isReflected(int[][] points) {
        Arrays.sort(points, Comparator.comparing((int[] i) -> i[1]).thenComparing(i -> i[0]));
        int sum = 0;
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            if (i > 0 && points[i][0] == points[i - 1][0] && points[i][1] == points[i - 1][1]) {
                continue;
            }
            sum += points[i][0];
            count++;
        }
        double line = (double) sum / count;
        LinkedList<Double> matches = new LinkedList<>();
        for (int i = 0; i < points.length; i++) {
            if (i > 0 && points[i][0] == points[i - 1][0] && points[i][1] == points[i - 1][1]) {
                continue;
            }
            int[] point = points[i];
            if (point[0] == line) {
                continue;
            } else {
                if (i > 0 && points[i][1] != points[i - 1][1]) {
                    if (matches.size() != 0) {
                        return false;
                    }
                }
                double diff = point[0] - line;
                if (diff < 0) {
                    matches.add(diff);
                } else {
                    if (!matches.isEmpty() && matches.peekLast() == -diff) {
                        matches.pollLast();
                    } else {
                        return false;
                    }
                }
            }
        }
        return matches.isEmpty();
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().isReflected(new int[][]{{-1, 1}, {1, 1}}));
//        System.out.println(new Solution().isReflected(new int[][]{{-1, -1}, {1, 1}}));
//        System.out.println(new Solution().isReflected(new int[][]{{-16, 1}, {16, 1}, {16, 1}}));
//        System.out.println(new Solution().isReflected(new int[][]{{1, 1}, {0, 0}, {-1, 1}}));
//        System.out.println(new Solution().isReflected(new int[][]{{0,0},{1,0}}));
        System.out.println(new Solution().isReflected(new int[][]{{1, 2}, {2, 2}, {3, 2}, {4, 2}}));
    }
}
