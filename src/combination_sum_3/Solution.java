package combination_sum_3;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    void dfs(List<List<Integer>> result, List<Integer> path, int current, int remain, int target) {
        if (remain == 1 && target > current && target <= 9) {
            path.add(target);
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        for (int i = current + 1; i <= 9; i++) {
            path.add(i);
            dfs(result, path, i, remain - 1, target - i);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int max = 0;
        int min = 0;
        for (int i = 0; i < k; ++i) {
            max += 9 - i;
            min += i;
        }
        if (n < min || n > max) {
            return result;
        }
        dfs(result, path, 0, k, n);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 9));
    }
}
