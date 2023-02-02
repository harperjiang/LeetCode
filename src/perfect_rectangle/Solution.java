package perfect_rectangle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {

        PriorityQueue<int[]> sorter = new PriorityQueue<>(Comparator.comparing((int[] input) -> input[0])
                .thenComparing((int[] i) -> i[1]));
        for (int[] r : rectangles) {
            sorter.add(r);
        }
//        int offset = 100001;
//        int[][] buffer = new int[2 * offset][2];
        int offset = 1;
        int[] buffer = new int[10];
        int x0 = sorter.peek()[0] + offset;
        int y0 = sorter.peek()[1] + offset;
        int y1 = 0;
        while (!sorter.isEmpty()) {
            int[] next = sorter.poll();

            int from = next[1] + offset;
            int to = next[3] + offset;
            int start = next[0] + offset;
            int end = next[2] + offset;
            int height = end - start;

            if (start == x0) {
                y1 = to;
            }
            if (buffer[from] > 0 && buffer[from] + x0 != start) {
                return false;
            }
            buffer[from] += height;
            buffer[to] -= height;
        }

        int sum = 0;
        for (int i = y0 + 1; i < y1; i++) {
            if (buffer[i] != 0) {
                return false;
            }
        }
        if (buffer[y0] + buffer[y1] != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isRectangleCover(new int[][]{
                {1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}
        }));
        System.out.println(new Solution().isRectangleCover(new int[][]{
                {0, 0, 4, 1}, {7, 0, 8, 2}, {6, 2, 8, 3}, {5, 1, 6, 3}, {4, 0, 5, 1}, {6, 0, 7, 2}, {4, 2, 5, 3}, {2, 1, 4, 3}, {0, 1, 2, 2}, {0, 2, 2, 3}, {4, 1, 5, 2}, {5, 0, 6, 1}
        }));
    }
}
