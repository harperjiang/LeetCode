package unique_binary_search_tree_2;

import com.sun.source.tree.Tree;

import java.util.*;

public class Solution {

    Map<Integer, List<TreeNode>> exist = new HashMap<>();

    List<TreeNode> gen(int start, int end) {
        if (exist.containsKey((start << 16) + end)) {
            return exist.get((start << 16) + end);
        }
        if (start == end) {
            return Collections.emptyList();
        }
        List<TreeNode> result = new ArrayList<>();
        if (start == end - 1) {
            return List.of(new TreeNode(start + 1));
        }
        for (int i = start; i < end; ++i) {
            // Center node = i
            List<TreeNode> left = gen(start, i);
            List<TreeNode> right = gen(i + 1, end);
            if (left.isEmpty()) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i + 1);
                    root.right = r;
                    result.add(root);
                }
            } else if (right.isEmpty()) {
                for (TreeNode l : left) {
                    TreeNode root = new TreeNode(i + 1);
                    root.left = l;
                    result.add(root);
                }
            } else for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i + 1);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        exist.put((start << 16) + end, result);
        return result;
    }

    public List<TreeNode> generateTrees(int n) {
        return gen(0, n);
    }

    public static void main(String[] args) {
        List<TreeNode> result = new Solution().generateTrees(3);
        System.out.println(result);
    }
}
