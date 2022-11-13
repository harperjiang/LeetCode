package triangle;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prev = triangle.get(triangle.size() - 1);
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> current = triangle.get(i);
            for (int j = 0; j < current.size(); j++) {
                current.set(j, current.get(j) + Math.min(prev.get(j), prev.get(j + 1)));
            }
            prev = current;
        }
        return triangle.get(0).get(0);
    }
}
