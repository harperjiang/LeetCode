package flatten_binary_tree_to_search_list;

public class Solution {

    TreeNode rflatten(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode lefttail = rflatten(root.left);
        TreeNode righttail = rflatten(root.right);
        TreeNode tempright = root.right;
        TreeNode templeft = root.left;
        root.left = null;
        root.right = null;
        TreeNode tail = lefttail;
        if (lefttail == null) {
            tail = root;
        } else {
            root.right = templeft;
        }
        if (righttail == null) {
            return tail;
        } else {
            tail.right = tempright;
            return righttail;
        }
    }

    public void flatten(TreeNode root) {
        rflatten(root);
    }
}
