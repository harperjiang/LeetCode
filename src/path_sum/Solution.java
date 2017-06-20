package path_sum;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {

	private boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (null == root)
			return false;
		if (isLeaf(root)) {
			return root.val == sum;
		}
		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val);
	}
}
