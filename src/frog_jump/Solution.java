package frog_jump;

import java.sql.Array;
import java.util.*;

public class Solution {
    public boolean canCross(int[] stones) {
        List<Set<Integer>> stoneReach = new ArrayList<>();

        if (stones[0] != 0 || stones[1] != 1) {
            return false;
        }
        stoneReach.add(Collections.emptySet());
        stoneReach.add(Set.of(1));
        for (int i = 1; i < stones.length; i++) {
            if (stoneReach.size() <= i) {
                return false;
            }
            Set<Integer> prevSteps = stoneReach.get(i);
            Set<Integer> nextSteps = new HashSet<>();

            for (int pstep : prevSteps) {
                nextSteps.add(pstep);
                nextSteps.add(pstep + 1);
                nextSteps.add(pstep - 1);
            }
            nextSteps.remove(0);
            for (int nstep : nextSteps) {
                int expectStone = stones[i] + nstep;
                int expectIndex = Arrays.binarySearch(stones, i + 1, stones.length, expectStone);
                if (expectIndex >= 0) {
                    while (stoneReach.size() <= expectIndex) {
                        stoneReach.add(new HashSet<>());
                    }
                    stoneReach.get(expectIndex).add(nstep);
                }
            }
        }
        return stoneReach.size() >= stones.length && stoneReach.get(stones.length - 1) != null
                && stoneReach.get(stones.length - 1).size() > 0;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        System.out.println(new Solution().canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }
}
