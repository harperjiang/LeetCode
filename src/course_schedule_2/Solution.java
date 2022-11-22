package course_schedule_2;

import java.util.*;

public class Solution {

    int[] take;
    int takePointer;

    boolean bfs(int index, Map<Integer, List<Integer>> paths, int[] required, int[] visited) {
        boolean[] cycledetect = new boolean[required.length];
        cycledetect[index] = true;
        LinkedList<Integer> buffer = new LinkedList<>();
        buffer.push(index);
        while (!buffer.isEmpty()) {
            int size = buffer.size();
            for (int i = 0; i < size; ++i) {
                int next = buffer.pop();
                List<Integer> path = paths.get(next);
                if (path != null) {
                    for (int e : path) {
                        if (cycledetect[e]) { // Cycle detected
                            return false;
                        }
                        visited[e]++;
                        if (visited[e] >= required[e]) {
                            cycledetect[e] = true;
                            buffer.push(e);
                            take[takePointer++] = e;
                        }
                    }
                }
            }
        }
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> paths = new HashMap<>();
        int[] required = new int[numCourses];
        int[] visited = new int[numCourses];
        take = new int[numCourses];
        takePointer = 0;

        for (int[] pre : prerequisites) {
            paths.computeIfAbsent(pre[1], i -> new ArrayList<>()).add(pre[0]);
            required[pre[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (required[i] == 0) {
                take[takePointer++] = i;
                if (!bfs(i, paths, required, visited)) {
                    return new int[]{};
                }
            }
        }

        if (takePointer == numCourses) {
            return take;
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
    }
}
