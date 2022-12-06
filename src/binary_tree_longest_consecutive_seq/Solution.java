package binary_tree_longest_consecutive_seq;

public class Solution {

    int[] path(TreeNode root) {
        if (root == null) {
            return new int[]{0, -40000};
        }
        if (root.left == null && root.right == null) {
            return new int[]{1, root.val};
        }

        int[] lres = path(root.left);
        int[] rres = path(root.right);

        int[] ret = new int[]{lres[0], -40000};
        if (root.val == lres[1] - 1) {
            ret = new int[]{lres[0] + 1, root.val};
        }
        if (root.val == rres[1] - 1 && ret[0] < rres[0] + 1) {
            ret = new int[]{rres[0] + 1, root.val};
        } else if (ret[0] < rres[0]) {
            ret = new int[]{rres[0], -40000};
        }
        if (ret[0] <= 1) {
            ret = new int[]{1, root.val};
        }
        return ret;
    }

    public int longestConsecutive(TreeNode root) {
        return path(root)[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(1);
        System.out.println(new Solution().longestConsecutive(root));
    }
}
