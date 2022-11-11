package validate_binary_search_tree;

public class Solution {


    // Scan the tree and get max
    public boolean scan(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if ((long)root.val < min) {
            return false;
        }
        if ((long)root.val > max) {
            return false;
        }
        return scan(root.left, min, ((long)root.val) - 1) && scan(root.right, ((long)root.val) + 1, max);
    }

    public boolean isValidBST(TreeNode root) {
        return scan(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        root.left = new TreeNode(Integer.MIN_VALUE);
        System.out.println(new Solution().isValidBST(root));
    }
}
