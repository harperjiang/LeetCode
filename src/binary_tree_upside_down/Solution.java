package binary_tree_upside_down;

import java.util.Stack;

public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        Stack<TreeNode[]> level = new Stack<>();
        TreeNode current = root;
        TreeNode rightSibling = null;
        while (current != null) {
            level.push(new TreeNode[]{current, rightSibling});
            rightSibling = current.right;
            TreeNode newcurrent = current.left;
            current.left = null;
            current.right = null;
            current = newcurrent;
        }
        TreeNode newroot = level.peek()[0];
        TreeNode prev = null;
        while (!level.isEmpty()) {
            TreeNode[] l = level.pop();
            if (prev != null) {
                prev.right = l[0];
            }
            prev = l[0];

            l[0].left = l[1];
        }

        return newroot;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        TreeNode newroot = new Solution().upsideDownBinaryTree(n1);
        return;
    }
}
