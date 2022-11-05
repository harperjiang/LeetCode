package subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    void dfs(List<Integer> path, List<List<Integer>> result, int[] nums, int index) {
        result.add(new ArrayList<>(path));
        if (path.size() == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(path, result, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(path, results, nums, 0);
        return results;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1, 2, 3}).stream().map(i -> i.stream()
                .map(k -> String.valueOf(k)).collect(Collectors.joining(","))).collect(Collectors.joining("\n")));
    }
}
