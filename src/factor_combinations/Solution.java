package factor_combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    void dfs(List<List<Integer>> result, List<Integer> path, int n, int min) {
        if (n > 1 && !path.isEmpty()) {
            path.add(n);
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        }

        for (int i = min; i * i <= n; ++i) {
            if (n % i == 0) {
                path.add(i);
                dfs(result, path, n / i, i);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(result, path, n, 2);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getFactors(12));
    }
}
