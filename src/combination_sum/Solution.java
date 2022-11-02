package combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return csum(candidates, target, candidates.length);
    }

    protected List<List<Integer>> csum(int[] candidates, int target, int limit) {
        if (target < candidates[0]) {
            return new ArrayList<>();
        }
        if (limit < 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        int index = Arrays.binarySearch(candidates, 0, limit, target);
        int startSearch = -1;
        if (index >= 0) {
            result.add(new ArrayList<>(List.of(target)));
            startSearch = index - 1;
        } else {
            startSearch = -index - 1 - 1;
        }
        while (startSearch > 0) {
            List<List<Integer>> subs = csum(candidates, target - candidates[startSearch], startSearch);
            for (List<Integer> sub : subs) {
                sub.add(candidates[startSearch]);
                result.add(sub);
            }
            startSearch--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2,3,6,7}, 7));
    }
}
