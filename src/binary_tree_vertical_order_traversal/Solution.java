package binary_tree_vertical_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    int colbase = 0;
    List<List<Integer>> result;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(new ArrayList<>());

        LinkedList<Object[]> buffer = new LinkedList<>();
        buffer.add(new Object[]{root, 0, 0});
        while (!buffer.isEmpty()) {
            int size = buffer.size();
            for (int i = 0; i < size; i++) {
                Object[] next = buffer.pop();
                TreeNode nt = (TreeNode) next[0];
                int row = (Integer) next[1];
                int col = (Integer) next[2];
                while (colbase + col < 0) {
                    result.add(0, new ArrayList<>());
                    colbase++;
                }
                while(colbase + col >= result.size()) {
                    result.add(new ArrayList<>());
                }
                result.get(colbase + col).add(nt.val);

                if (nt.left != null) {
                    buffer.add(new Object[]{nt.left, row + 1, col - 1});
                }
                if (nt.right != null) {
                    buffer.add(new Object[]{nt.right, row + 1, col + 1});
                }
            }
        }

        return result;
    }
}
