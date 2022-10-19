package recovery_binary_search_tree;

import org.junit.Test;

/**
 * Created by harper on 10/15/17.
 */
public class SolutionTest {
    @Test
    public void testSolution() {
        Solution sol = new Solution();

        TreeNode root;
//        root = new TreeNode(0);
//        root.left = new TreeNode(1);
//
//        sol.recoverTree(root);

        root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        sol.recoverTree(root);
//        root = new TreeNode(3);
//        root.right = new TreeNode(2);
//        root.right.right = new TreeNode(1);
//        sol.recoverTree(root);
    }
}
