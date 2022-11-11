package subsets_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    void dfs(List<Integer> path, List<List<Integer>> result, int[] nums, int index) {
            result.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(path, result, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
            dfs(path, results, nums, 0);
        return results;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[]{1, 2, 2}).stream().map(i -> i.stream()
                .map(k -> String.valueOf(k)).collect(Collectors.joining(","))).collect(Collectors.joining("\n")));
    }
}
