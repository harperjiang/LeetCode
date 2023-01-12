package water_and_jug_problem;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    boolean dfs(int s1, int s2, Set<Long> visited) {
//        System.out.println(MessageFormat.format("{0},{1}",s1,s2));
        if (s1 == t || s2 == t || s1 + s2 == t) {
            return true;
        }
        long state = (((long) s1) << 32) + s2;
        if (visited.contains(state)) {
            return false;
        }
        visited.add(state);
        // Find next step
        if(dfs(s1,0,visited)) {
            return true;
        }
        if(dfs(0,s2,visited)) {
            return true;
        }
        if (s1 < c1) {
            if (dfs(c1, s2, visited))// Fill j1
                return true;
            // Two conditions of pour j2 to j1
            if (c1 - s1 >= s2 && dfs(s1 + s2, 0, visited)) {
                return true;
            }
            if (c1 - s1 < s2 && dfs(c1, s2 - c1 + s1, visited)) {
                return true;
            }
        }
        if (s2 < c2) { // Fill J2
            if (dfs(s1, c2, visited))
                return true;
            // Two conditions of pour j1 to j2
            if (c2 - s2 >= s1 && dfs(0, s1 + s2, visited)) {
                return true;
            }
            if (c2 - s2 < s1 && dfs(s1 - c2 + s2, c2, visited)) {
                return true;
            }
        }

        return false;
    }

    int c1, c2, t;

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        c1 = jug1Capacity;
        c2 = jug2Capacity;
        t = targetCapacity;
        Set<Long> visited = new HashSet<>();
        return dfs(0, 0, visited);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canMeasureWater(3, 5, 4));
//        System.out.println(new Solution().canMeasureWater(2, 6, 5));
//        System.out.println(new Solution().canMeasureWater(1, 2, 3));
    }
}
