package number_of_boomrangs;

import java.util.*;

public class Solution {
    public int numberOfBoomerangs(int[][] points) {

        Map<Integer, Map<Integer, Integer>> buffer = new HashMap<>();

        int counter = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> bufferi = new HashMap<>();

            for (int j = 0; j < i; j++) {
                int xdiff = points[i][0] - points[j][0];
                int ydiff = points[i][1] - points[j][1];
                int distij = xdiff * xdiff + ydiff * ydiff;
                if (buffer.get(j).containsKey(distij)) {
                    int exist = buffer.get(j).get(distij);
                    counter += 2 * exist;
                    buffer.get(j).put(distij, exist + 1);
                } else {
                    buffer.get(j).put(distij, 1);
                }
                bufferi.put(distij, bufferi.getOrDefault(distij, 0) + 1);
            }

            for (int count : bufferi.values()) {
                if (count > 1) {
                    counter += count * (count - 1) / 2;
                }
            }

            buffer.put(i, bufferi);
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfBoomerangs(new int[][]{
                {0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        }));
    }
}
