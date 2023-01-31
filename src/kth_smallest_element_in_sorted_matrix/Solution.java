package kth_smallest_element_in_sorted_matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> buffer = new PriorityQueue<>(Comparator.comparing((int[] m) -> matrix[m[0]][m[1]]));
        for (int i = 0; i < n && i < k; i++) {
            buffer.add(new int[]{0, i});
        }
        int val = -1;
        for (int i = 0; i < k; i++) {
            int[] next = buffer.poll();
            val = matrix[next[0]][next[1]];
            if (next[0] + 1 < n)
                buffer.add(new int[]{next[0] + 1, next[1]});
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kthSmallest(new int[][]{
                {1,5,9},{10,11,13},{12,13,15}
        },8));
        System.out.println(new Solution().kthSmallest(new int[][]{ {-5} },1));
        System.out.println(new Solution().kthSmallest(new int[][]{{1, 2}, {1, 3}}, 2));
    }
}
