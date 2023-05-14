package path_sum_3;

import java.util.*;

public class Solution {

    int counter;

    public void visit(TreeNode root, int sumBefore, Map<Integer, Integer> prefixSum, int target) {
        int sum = sumBefore + root.val;
        if (sum == target) {
            counter++;
        }
        counter += prefixSum.getOrDefault(sum - target, 0);

        prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        if (root.left != null) {
            visit(root.left, sumBefore + root.val, prefixSum, target);
        }
        if (root.right != null) {
            visit(root.right, sumBefore + root.val, prefixSum, target);
        }
        prefixSum.put(sum, prefixSum.get(sum)-1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        visit(root,0,new HashMap<>(),targetSum);
        return counter;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(-2);
        root.right.right = new TreeNode(1);

        System.out.println(new Solution().pathSum(root, 8));
    }
}
