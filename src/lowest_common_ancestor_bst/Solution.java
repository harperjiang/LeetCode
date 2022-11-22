package lowest_common_ancestor_bst;

public class Solution {

    TreeNode search(TreeNode root, int small, int big) {
        TreeNode current = root;
        while(true) {
            if (current.val == small || current.val == big) {
                return current;
            }
            if (current.val < big && current.val > small) {
                return current;
            }
            if (current.val > big) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode small = p.val < q.val ? p : q;
        TreeNode big = small == p ? q : p;
        return search(root, small.val, big.val);
    }
}
