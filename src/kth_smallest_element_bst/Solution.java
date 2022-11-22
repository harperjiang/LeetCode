package kth_smallest_element_bst;

import com.sun.source.tree.Tree;

public class Solution {

    int[] scan(TreeNode root, int k) {
        if (root == null) {
            return new int[]{-1, 0};
        }
        int[] res = scan(root.left, k);
        if (res[0] != -1) {
            return res;
        }
        if (k == res[1] + 1) {
            return new int[]{root.val, res[1] + 1};
        }
        int[] right = scan(root.right, k - res[1] - 1);
        if (right[0] != -1) {
            return right;
        } else {
            return new int[]{-1, res[1] + 1 + right[1]};
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        return scan(root, k)[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(new Solution().kthSmallest(root, 3));
    }
}
