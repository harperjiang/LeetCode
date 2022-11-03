package combination_sum_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        csum(0, target, candidates, path, result);
        return result;
    }

    protected void csum(int index, int target, int[] candidates, List<Integer> path, List<List<Integer>> result) {
        if(target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; ++i) {
            if (i > index && candidates[i] == candidates[index]) {
                continue;
            }
            index = i;
            // Choose candidates[i]
            path.add(candidates[i]);
            csum(i + 1, target - candidates[i], candidates, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().combinationSum2(new int[]{2, 3, 6, 7}, 7));
//        System.out.println(new Solution().combinationSum2(new int[]{2, 3, 5}, 8));
//        System.out.println(new Solution().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
//        System.out.println(new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(new Solution().combinationSum2(new int[]{3, 1, 3, 5, 1, 1}, 8));
    }
}
