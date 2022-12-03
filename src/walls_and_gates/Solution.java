package walls_and_gates;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        int gateCounter = 1;
        List<int[]> gates = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Found all gates
                if (rooms[i][j] == 0) {
                    rooms[i][j] += (gateCounter++) << 16;
                    gates.add(new int[]{i, j});
                }
            }
        }
        List<LinkedList<int[]>> buffers = new ArrayList<>();
        for (int[] gate : gates) {
            LinkedList<int[]> buffer = new LinkedList<>();
            buffer.add(gate);
            buffers.add(buffer);
        }
        while (true) {
            int counter = buffers.size();
            for (int i = 0; i < buffers.size(); i++) {
                int partition = i + 1;
                LinkedList<int[]> buffer = buffers.get(i);
                if (buffer.isEmpty()) {
                    counter--;
                } else {
                    // Push BFS
                    int size = buffer.size();
                    for (int j = 0; j < size; ++j) {
                        int[] current = buffer.pop();
                        int roomval = rooms[current[0]][current[1]];
                        int cpart = roomval >> 16;
                        if (cpart == partition) { // Otherwise, this node no longer belongs to me
                            int cstep = roomval & 0xFFFF;
                            for (int[] dir : dirs) {
                                int nx = current[0] + dir[0];
                                int ny = current[1] + dir[1];
                                int nstep = cstep + 1;
                                if (nx >= 0 && nx < m && ny >= 0 && ny < n && rooms[nx][ny] != -1) {
                                    if (rooms[nx][ny] == Integer.MAX_VALUE || (rooms[nx][ny] & 0xFFFF) > nstep) {
                                        rooms[nx][ny] = (cpart << 16) + nstep;
                                        buffer.push(new int[]{nx, ny});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (counter == 0) { // All empty;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] != -1 && rooms[i][j] != Integer.MAX_VALUE) {
                    rooms[i][j] &= 0xFFFF;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Solution().wallsAndGates(new int[][]{
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        });
    }
}
