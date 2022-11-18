package binary_search_tree_iterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> path = new Stack<>();

    void down(TreeNode from) {
        TreeNode current = from;
        while (current != null) {
            path.push(current);
            current = current.left;
        }
    }

    public BSTIterator(TreeNode root) {
        down(root);
    }

    public int next() {
        TreeNode current = path.pop();
        if (current.right != null) {
            down(current.right);
        }
        return current.val;

    }

    public boolean hasNext() {
        return !path.isEmpty();
    }
}
