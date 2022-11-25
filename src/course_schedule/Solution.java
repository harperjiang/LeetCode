package course_schedule;

import java.util.*;

public class Solution {

    boolean bfs(int index, Map<Integer, List<Integer>> paths, int[] visitCounter, int[] required) {
        boolean[] visited = new boolean[visitCounter.length];
        visited[index] = true;
        visitCounter[index]++;
        int current = index;
        LinkedList<Integer> buffer = new LinkedList<>();
        buffer.add(current);
        while (!buffer.isEmpty()) {
            int size = buffer.size();
            for (int i = 0; i < size; ++i) {
                int next = buffer.pop();
                List<Integer> enabled = paths.get(next);
                if (enabled == null) {
                    continue;
                }
                for (int e : enabled) {
                    if (visited[e]) {
                        return false; // loop detection
                    }
                    if (visitCounter[e] < required[e]) {
                        visitCounter[e]++;
                        if (visitCounter[e] == required[e]) {
                            visited[e] = true;
                            buffer.push(e);
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] require = new int[numCourses];
        int[] visitCounter = new int[numCourses];
        Map<Integer, List<Integer>> paths = new HashMap<>();
        for (int[] edge : prerequisites) {
            require[edge[0]] += 1;
            paths.computeIfAbsent(edge[1], i -> new ArrayList<>()).add(edge[0]);
        }
        for (int i = 0; i < numCourses; ++i) {
            if (require[i] == 0) {
                if (!bfs(i, paths, visitCounter, require)) {
                    return false;
                }
            }
        }
        for (int i = 0; i < numCourses; ++i) {
            if (visitCounter[i] == 0|| visitCounter[i]<require[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(4, new int[][]{
                {2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}
        }));
    }
}
