package pacific_atlantic_ocean_flow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    static int[][] dirs = new int[][] {
            {-1,0},{1,0},{0,-1},{0,1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] state = new int[m][n];

        LinkedList<int[]> preach = new LinkedList<>();
        LinkedList<int[]> areach = new LinkedList<>();

        for(int i = 0 ; i < m;i++) {
            state[i][0] |= 1;
            state[i][n-1] |= 2;
            preach.add(new int[]{i,0});
            areach.add(new int[]{i,n-1});
        }
        for(int i = 0 ; i < n ; i++) {
            state[0][i] |= 1;
            state[m-1][i] |= 2;
            preach.add(new int[]{0,i});
            areach.add(new int[]{m-1,i});
        }

        while(!preach.isEmpty()) {
            int size = preach.size();
            for(int i = 0 ; i < size; i++) {
                int[] next = preach.poll();
                int height = heights[next[0]][next[1]];
                for(int[] dir: dirs) {
                    int nx = next[0] + dir[0];
                    int ny = next[1] + dir[1];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && (state[nx][ny] & 1) == 0) {
                        if(heights[nx][ny]>= height) {
                            state[nx][ny] |= 1;
                            preach.add(new int[]{nx,ny});
                        }
                    }
                }
            }
        }

        while(!areach.isEmpty()) {
            int size = areach.size();
            for(int i = 0 ; i < size; i++) {
                int[] next = areach.poll();
                int height = heights[next[0]][next[1]];
                for(int[] dir: dirs) {
                    int nx = next[0] + dir[0];
                    int ny = next[1] + dir[1];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && (state[nx][ny] & 2) == 0) {
                        if(heights[nx][ny]>= height) {
                            state[nx][ny] |= 2;
                            areach.add(new int[]{nx,ny});
                        }
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i < m ;i++) {
            for(int j = 0;j<n;j++) {
                if(state[i][j]==3)
                    result.add(List.of(i,j));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().pacificAtlantic(new int[][]{{2,1},{1,2}});
    }
}

