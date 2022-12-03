package graph_valid_tree;

import java.util.*;

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 1) {
            return true;
        }
        int[] appear = new int[n];
        Map<Integer, List<Integer>> regions = new HashMap<>();
        int counter = 1;
        for (int[] edge : edges) {
            if (appear[edge[0]] == appear[edge[1]]) {
                // circle appears
                if (appear[edge[0]] != 0) {
                    return false;
                }
            }
            if (appear[edge[0]] == 0 && appear[edge[1]] == 0) {
                List<Integer> region = regions.computeIfAbsent(counter, c -> new ArrayList<>());
                appear[edge[0]] = counter;
                appear[edge[1]] = counter++;
                region.add(edge[0]);
                region.add(edge[1]);
            } else if (appear[edge[0]] == 0) {
                appear[edge[0]] = appear[edge[1]];
                regions.get(appear[edge[1]]).add(edge[0]);
            } else if (appear[edge[1]] == 0) {
                appear[edge[1]] = appear[edge[0]];
                regions.get(appear[edge[0]]).add(edge[1]);
            } else {
                int small = Math.min(appear[edge[0]], appear[edge[1]]);
                int big = appear[edge[0]] + appear[edge[1]] - small;
                List<Integer> bigs = regions.remove(big);
                regions.get(small).addAll(bigs);
                for (int b : bigs) {
                    appear[b] = small;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (appear[i] != 1) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
//        System.out.println(new Solution().validTree(1, new int[][]{}));
    }
}
