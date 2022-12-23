package house_robber_3;

import com.sun.source.tree.Tree;

public class Solution {
    public int rob(TreeNode root) {
        int[] choose = choose(root);
        return Math.max(choose[0], choose[1]);
    }

    int[] EMPTY = new int[]{0, 0};

    int[] choose(TreeNode root) {
        // ret[0] is the max of choosing root, ret[1] is the max value when not choosing it
        if (root == null) {
            return EMPTY;
        }
        int[] left = choose(root.left);
        int[] right = choose(root.right);

        return new int[]{left[1] + right[1] + root.val, Math.max(left[1], left[0]) + Math.max(right[1], right[0])};
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        System.out.println(new Solution().rob(root));
    }
}
