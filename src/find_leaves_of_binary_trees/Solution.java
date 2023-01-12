package find_leaves_of_binary_trees;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    Map<TreeNode, Integer> incomings;
    Map<TreeNode, TreeNode> parents;

    void traverse(TreeNode root) {
        if (root == null) return;
        int incoming = 0;
        if (root.left != null) {
            parents.put(root.left, root);
            incoming++;
        }
        if (root.right != null) {
            parents.put(root.right, root);
            incoming++;
        }
        incomings.put(root, incoming);
        traverse(root.left);
        traverse(root.right);
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        incomings = new HashMap<>();
        parents = new HashMap<>();
        traverse(root);

        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> currentNodes = new ArrayList<>();
        for (HashMap.Entry<TreeNode, Integer> entry : incomings.entrySet()) {
            if (entry.getValue() == 0) {
                currentNodes.add(entry.getKey());
            }
        }
        List<Integer> current = new ArrayList<>();
        for(TreeNode tn:currentNodes) {
            current.add(tn.val);
        }
        result.add(current);

        List<TreeNode> nextNodes = new ArrayList<>();
        while (!currentNodes.isEmpty()) {
            nextNodes.clear();
            for (TreeNode i : currentNodes) {
                TreeNode p = parents.get(i);
                if (p != null) {
                    int incoming = incomings.get(p);
                    incoming--;
                    incomings.put(p,incoming);
                    if (incoming == 0) {
                        nextNodes.add(p);
                    }
                }
            }
            currentNodes.clear();
            currentNodes.addAll(nextNodes);
            if (!currentNodes.isEmpty()) {
                List<Integer> cn = new ArrayList<>();
                for(TreeNode tn:currentNodes) {
                    cn.add(tn.val);
                }
                result.add(cn);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        System.out.println(new Solution().findLeaves(root));
    }
}
