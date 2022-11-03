package combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        csum(0, target, candidates, path, result);
        return result;
    }

    protected void csum(int index, int target, int[] candidates, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; ++i) {
            int c = candidates[i];
            int maxrep = target / c;
            for (int j = 1; j <= maxrep; ++j) {
                for (int k = 0; k < j; ++k)
                    path.add(c);
                csum(i + 1, target - j * c, candidates, path, result);
                for (int k = 0; k < j; ++k)
                    path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(new Solution().combinationSum(new int[]{2, 3, 5}, 8));
    }
}
