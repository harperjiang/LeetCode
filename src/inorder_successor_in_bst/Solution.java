package inorder_successor_in_bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    TreeNode find(Stack<TreeNode> path, TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        path.push(root);
        if (root.val == p.val) {
            return root;
        }
        if (root.val > p.val) {
            return find(path, root.left, p);
        } else {
            return find(path, root.right, p);
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> path = new Stack<>();
        TreeNode found = find(path, root, p);
        if (found != null && found.right != null) {// Has next
            found = found.right;
            while (found.left != null) {
                found = found.left;
            }
            return found;
        }
        while (!path.isEmpty() && path.peek().val <= p.val) {
            path.pop();
        }
        if (path.isEmpty()) {
            return null;
        }
        return path.peek();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(new Solution().inorderSuccessor(root, new TreeNode(1)).val);
    }
}
