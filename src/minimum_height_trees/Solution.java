package minimum_height_trees;

import java.sql.Array;
import java.util.*;

import static java.util.Comparator.comparing;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        if (adj.get(0).size() == 0) {
            return List.of(0);
        }


        int[] parent = new int[n];
        int[] depth = new int[n];
        Arrays.fill(depth, -1);
        depth[0] = 0;

        LinkedList<Integer> buffer = new LinkedList<>();
        buffer.add(0);
        while (!buffer.isEmpty()) {
            int size = buffer.size();
            for (int i = 0; i < size; ++i) {
                int current = buffer.pop();
                List<Integer> nexts = adj.get(current);
                for (int next : nexts) {
                    if (depth[next] == -1) {
                        depth[next] = depth[current] + 1;
                        buffer.add(next);
                    }
                }
            }
        }
        int maxdepth = -1;
        int point = 0;
        for (int i = 0; i < n; i++) {
            if (depth[i] > maxdepth) {
                maxdepth = depth[i];
                point = i;
            }
        }
        buffer.add(point);
        Arrays.fill(depth, -1);
        depth[point] = 0;

        while (!buffer.isEmpty()) {
            int size = buffer.size();
            for (int i = 0; i < size; ++i) {
                int current = buffer.pop();
                List<Integer> nexts = adj.get(current);
                for (int next : nexts) {
                    if (depth[next] == -1) {
                        parent[next] = current;
                        depth[next] = depth[current] + 1;
                        buffer.add(next);
                    }
                }
            }
        }
        maxdepth = -1;
        int point2 = 0;
        for (int i = 0; i < n; i++) {
            if (depth[i] > maxdepth) {
                maxdepth = depth[i];
                point2 = i;
            }
        }
        if (maxdepth % 2 == 1) { // Two
            int round = (maxdepth - 1) / 2;
            int pointer = point2;
            for (int i = 0; i < round; i++) {
                pointer = parent[pointer];
            }
            return List.of(pointer, parent[pointer]);
        } else {
            int round = maxdepth / 2;
            int pointer = point2;
            for (int i = 0; i < round; i++) {
                pointer = parent[pointer];
            }
            return List.of(pointer);
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
//        System.out.println(new Solution().findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}));
//        System.out.println(new Solution().findMinHeightTrees(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {3, 4}}));
        System.out.println(new Solution().findMinHeightTrees(7, new int[][]{{0, 1}, {1, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}}));
    }
}
