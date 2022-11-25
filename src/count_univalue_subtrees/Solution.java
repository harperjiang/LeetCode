package count_univalue_subtrees;

public class Solution {

    int[] scan(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return new int[]{root.val, 1};
        }
        int[] left = scan(root.left);
        int[] right = scan(root.right);
        int newvalue = (left == null || left[0] == root.val) && (right == null || right[0] == root.val) ? root.val : -1001;
        int newcount = (left == null ? 0 : left[1]) + (right == null ? 0 : right[1]);
        if (newvalue != -1001) {
            newcount++;
        }
        return new int[]{newvalue, newcount};
    }

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return scan(root)[1];
    }
}
