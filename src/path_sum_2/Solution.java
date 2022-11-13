package path_sum_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    void search(List<List<Integer>> result, List<Integer> path, TreeNode root, int targetSum) {
        if (root.left == null && root.right == null && targetSum == 0) {//leaf
            result.add(List.copyOf(path));
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            search(result, path, root.left, targetSum - root.left.val);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            search(result, path, root.right, targetSum - root.right.val);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        search(result, path, root, targetSum - root.val);
        return result;
    }
}
