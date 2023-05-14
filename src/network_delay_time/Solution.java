package network_delay_time;

import java.util.*;

public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] time : times) {
            edges.computeIfAbsent(time[0], (Integer i) -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        boolean visited[] = new boolean[n + 1];

        while(true) {
            int min = Integer.MAX_VALUE;
            int mini = -1;
            for(int i = 1 ; i <= n; i++) {
                if(!visited[i]) {
                    if(dist[i] < min) {
                        min = dist[i];
                        mini = i;
                    }
                }
            }
            if(mini == -1) break;
            // Process node i;
            for(int[] edge: edges.getOrDefault(mini, Collections.emptyList())) {
                if(dist[mini]+edge[1] < dist[edge[0]]) {
                    dist[edge[0]] = dist[mini] + edge[1];
                }
            }
            visited[mini] = true;
        }

        int max = -1;
        for (int i = 1;i<=n;i++) {
            max = Math.max(dist[i], max);
        }
        if(max == Integer.MAX_VALUE)return -1;
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(new Solution().networkDelayTime(new int[][]{
                        {3, 5, 78}, {2, 1, 1}, {1, 3, 0}, {4, 3, 59}, {5, 3, 85}, {5, 2, 22}, {2, 4, 23}, {1, 4, 43}, {4, 5, 75}, {5, 1, 15}, {1, 5, 91}, {4, 1, 16}, {3, 2, 98}, {3, 4, 22}, {5, 4, 31}, {1, 2, 0}, {2, 5, 4}, {4, 2, 51}, {3, 1, 36}, {2, 3, 59}
                },
                5, 5));
    }
}
