package best_meeting_point;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    xs.add(i);
                    ys.add(j);
                }
            }
        }
        ys.sort(Comparator.naturalOrder());
        int pos = (xs.size() - 1) / 2;

        int homex = xs.get(pos);
        int homey = ys.get(pos);
        int sum = 0;
        for (int i = 0; i < xs.size(); i++) {
            sum += Math.abs(xs.get(i) - homex);
            sum += Math.abs(ys.get(i) - homey);
        }
        return sum;
    }
}
