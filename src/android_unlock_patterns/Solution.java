package android_unlock_patterns;

import java.util.LinkedList;
import java.util.Map;

public class Solution {

    Map<Integer, Integer> checks = Map.of(5, 2, 65, 8, 260, 32, 320, 128, 257, 16, 68, 16, 130, 16, 40, 16);

    int[][] cache = new int[512][9];

    public int numberOfPatterns(int m, int n) {
        LinkedList<int[]> buffer = new LinkedList<>();

        for (int i = 0; i < 9; i++) {
            int state = 1 << i;
            buffer.add(new int[]{state, i});
            cache[state][i] = 1;
        }
        int sum = m == 1 ? 9 : 0;
        if(n==1) {
            return sum;
        }
        int depth = 1;
        while (!buffer.isEmpty() && depth < n) {
            depth++;
            int size = buffer.size();
            for (int i = 0; i < size; ++i) {
                int[] prev = buffer.pop();
                int state = prev[0];
                int last = prev[1];
                for (int next = 0; next < 9; next++) {
                    if ((state & (1 << next)) == 0) { // not visited
                        // can go from last to next?
                        int check = (1 << last) + (1 << next);
                        if ((checks.getOrDefault(check, 0xFFFFFFFF) & state) > 0) {
                            int newstate = state | (1 << next);
                            if (cache[newstate][next] == 0) {
                                buffer.add(new int[]{newstate, next});
                            }
                            cache[newstate][next] += cache[state][last];
                            if (depth >= m) {
                                sum += cache[state][last];
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfPatterns(1, 3));
    }
}
