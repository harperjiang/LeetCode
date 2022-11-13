package sum_root_to_leaf_numbers;

import java.util.LinkedList;

public class Solution {
    public int sumNumbers(TreeNode root) {
        LinkedList<TreeNode> buffer = new LinkedList<>();
        buffer.add(root);
        int sum = 0;
        while (!buffer.isEmpty()) {
            int size = buffer.size();
            for (int i = 0; i < size; ++i) {
                TreeNode current = buffer.pop();
                if (current.left == null && current.right == null) {
                    sum += current.val;
                } else {
                    if (current.left != null) {
                        current.left.val += current.val * 10;
                        buffer.add(current.left);
                    }
                    if (current.right != null) {
                        current.right.val += current.val * 10;
                        buffer.add(current.right);
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new Solution().sumNumbers(root));
    }
}
