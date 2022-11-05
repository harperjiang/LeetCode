package combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    void dfs(List<Integer> path, List<List<Integer>> result, int i, int n, int k) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        int remain = k - path.size();
        for (int idx = i; idx <= n - remain; idx++) {
            path.add(idx + 1);
            dfs(path, result, idx + 1, n, k);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(path, result, 0, n, k);
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().combine(10, 4).stream().map(i -> i.stream()
//                .map(k -> String.valueOf(k)).collect(Collectors.joining(","))).collect(Collectors.joining("\n")));
        System.out.println(new Solution().combine(4, 2).stream().map(i -> i.stream()
                .map(k -> String.valueOf(k)).collect(Collectors.joining(","))).collect(Collectors.joining("\n")));
        System.out.println(new Solution().combine(1, 1).stream().map(i -> i.stream()
                .map(k -> String.valueOf(k)).collect(Collectors.joining(","))).collect(Collectors.joining("\n")));
    }
}
