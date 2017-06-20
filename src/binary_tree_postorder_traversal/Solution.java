package binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (null == root)
			return result;
		List<TreeNode> seq = new LinkedList<TreeNode>();
		seq.add(root);

		for (int i = 0; i < seq.size(); i++) {
			TreeNode current = seq.get(i);
			int pos = i + 1;
			if (current.right != null) {
				if (seq.size() <= pos) {
					seq.add(current.right);
				} else {
					seq.add(pos, current.right);
				}
				pos++;
			}
			if (current.left != null) {
				if (seq.size() <= pos) {
					seq.add(current.left);
				} else {
					seq.add(pos, current.left);
				}
			}
		}
		for (int i = 0; i < seq.size(); i++) {
			result.add(seq.get(seq.size() - 1 - i).val);
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode c1 = new TreeNode(2);
		root.left = c1;
		List<Integer> res = new Solution().postorderTraversal(root);
		for (int i : res) {
			System.out.println(i);
		}
	}
}
