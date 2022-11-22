package count_complete_tree_node;

import java.util.LinkedList;

public class Solution {

    int lheight(TreeNode root) {
        int count = 0;
        TreeNode current = root;
        while (current != null) {
            count++;
            current = current.left;
        }
        return count;
    }

    int rheight(TreeNode root) {
        int count = 0;
        TreeNode current = root;
        while (current != null) {
            count++;
            current = current.right;
        }
        return count;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = lheight(root.left);
        int rh = rheight(root.right);
        if (lh == rh) {
            return (1 << (lh + 1)) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(new Solution().countNodes(root));
    }
}
