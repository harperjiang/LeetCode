package find_the_celebrity;

import java.util.*;

public class Solution {
    public int findCelebrity(int n) {
        List<Integer> candidates = new ArrayList<Integer>();
        for (int i = 1; i < n; i++) {
            if (!knows(i, 0)) {
                candidates.add(i);
            }
        }
        if(candidates.isEmpty()) {
            candidates.add(0);
        }
        for (int i = 1; i < n; i++) {
            if (candidates.contains(i)) {
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        if (!knows(j, i)) {
                            candidates.remove((Integer) i);
                        } else {
                            candidates.remove((Integer) j);
                        }
                    }
                }
            } else {
                List<Integer> newcand = new ArrayList<Integer>();
                if (candidates.isEmpty()) {
                    return -1;
                }
                for (int c : candidates) {
                    if (!knows(c, i)) {
                        newcand.add(c);
                    }
                }
                candidates = newcand;
            }
        }
        return candidates.isEmpty() ? -1 : candidates.get(0);
    }

    public boolean knows(int i, int j) {
        return graph[i][j] == 1;
    }

    int[][] graph = new int[][]{{1, 0}, {0, 1}};

    public static void main(String[] args) {
        System.out.println(new Solution().findCelebrity(2));
    }
}
