package closest_binary_search_tree_value_2;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution {

    void traverse(TreeNode root, TreeSet<Integer> buffer, double target, int k) {
        if (root == null) {
            return;
        }
        buffer.add(root.val);
        if (buffer.size() > k) {
            buffer.remove(Math.abs(buffer.first() - target) > Math.abs(buffer.last() - target) ? buffer.first() : buffer.last());
        }
        traverse(root.left, buffer, target, k);
        traverse(root.right, buffer, target, k);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        TreeSet<Integer> buffer = new TreeSet<>();
        traverse(root, buffer, target, k);
        return new ArrayList<>(buffer);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(new Solution().closestKValues(root, 2.00, 1));
    }
}
