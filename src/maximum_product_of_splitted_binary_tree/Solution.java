package maximum_product_of_splitted_binary_tree;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    void sum(TreeNode root) {
        if (root != null) {
            sum(root.left);
            sum(root.right);
            if (root.left != null)
                root.val += root.left.val;
            if (root.right != null)
                root.val += root.right.val;
        }
    }

    long maxprod(TreeNode root, long sum) {
        if (root == null) {
            return 0;
        }
        long max = Long.MIN_VALUE;
        if (root.left != null) {
            max = Math.max(max, root.left.val * (sum - root.left.val));
            if (root.left.val >= sum / 2)
                max = Math.max(max, maxprod(root.left, sum));
        }
        if (root.right != null) {
            max = Math.max(max, root.right.val * (sum - root.right.val));
            if (root.right.val >= sum / 2)
                max = Math.max(max, maxprod(root.right, sum));
        }
        return max;
    }


    public int maxProduct(TreeNode root) {
        sum(root);
        int sum = root.val;
        long maxprod = maxprod(root, sum);

        return (int) (maxprod % 1000000007);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(2);
        root.left.left.left = new TreeNode(10);
        root.left.left.right = new TreeNode(6);
        root.left.left.right.right = new TreeNode(10);
        root.right.right.right = new TreeNode(6);

        System.out.println(new Solution().maxProduct(root));
    }
}
