package binary_tree_max_pathsum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	private Map<TreeNode, Integer> cache = new HashMap<TreeNode, Integer>();

	private int infadd(int... nums) {
		long sum = 0;
		for (int num : nums) {
			if (num == Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			sum += num;
			if (num <= Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}
		return (int) sum;
	}

	public int maxPathSum(TreeNode root) {
		if (null == root)
			return Integer.MIN_VALUE;
		int maxLeft = maxPathSum(root.left);
		int maxRight = maxPathSum(root.right);
		int singleLeft = maxSinglePath(root.left);
		int singleRight = maxSinglePath(root.right);

		int[] candidate = new int[] { maxLeft, maxRight, singleLeft,
				singleRight, infadd(singleLeft, root.val),
				infadd(singleRight, root.val), root.val,
				infadd(singleLeft, singleRight, root.val) };
		int max = maxLeft;
		for (int i : candidate)
			max = Math.max(i, max);
		return max;
	}

	private int maxSinglePath(TreeNode node) {
		if (null == node)
			return Integer.MIN_VALUE;
		if (cache.containsKey(node))
			return cache.get(node);

		int val = Math.max(
				node.val,
				Math.max(infadd(maxSinglePath(node.left), node.val),
						infadd(maxSinglePath(node.right), node.val)));
		cache.put(node, val);
		return val;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(-1);
		System.out.println(new Solution().maxPathSum(root));
	}
}
