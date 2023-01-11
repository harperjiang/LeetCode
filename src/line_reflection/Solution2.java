package line_reflection;

import java.util.HashSet;

public class Solution2 {

    class Point {
        int x;int y;
        Point(int[] p) {
            x = p[0];
            y = p[1];
        }

        Point(int x,int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
    public boolean isReflected(int[][] points) {

        HashSet<Point> exist = new HashSet<>();
        double sum = 0;
        for (int[] point : points) {
            Point p = new Point(point);
            if (!exist.contains(p)) {
                sum += point[0];
                exist.add(p);
            }
        }
        double line = sum / exist.size();
        int counter = 0;
        for (Point point : exist) {
            if (point.x < line && exist.contains(new Point((int) (2 * line - point.x), point.y))) {
                counter += 2;
            } else if (point.x == line) {
                counter++;
            }
        }
        return counter == exist.size();
    }

    public static void main(String[] args) {
//        System.out.println(new Solution2().isReflected(new int[][]{{-1, 1}, {1, 1}}));
//        System.out.println(new Solution().isReflected(new int[][]{{-1, -1}, {1, 1}}));
        System.out.println(new Solution2().isReflected(new int[][]{{-16, 1}, {16, 1}, {16, 1}}));
//        System.out.println(new Solution().isReflected(new int[][]{{1, 1}, {0, 0}, {-1, 1}}));
//        System.out.println(new Solution().isReflected(new int[][]{{0,0},{1,0}}));
//        System.out.println(new Solution().isReflected(new int[][]{{1, 2}, {2, 2}, {3, 2}, {4, 2}}));
    }
}
