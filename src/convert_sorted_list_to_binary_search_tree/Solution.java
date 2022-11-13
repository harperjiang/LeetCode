package convert_sorted_list_to_binary_search_tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    TreeNode build(List<Integer> buffer, int start, int end) {
        if (start == end) {
            return null;
        }
        int rootidx = (start + end) / 2;
        TreeNode root = new TreeNode(buffer.get(rootidx));
        root.left = build(buffer, start, rootidx);
        root.right = build(buffer, rootidx + 1, end);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> buffer = new ArrayList<>();
        ListNode pointer = head;
        while (pointer != null) {
            buffer.add(pointer.val);
            pointer = pointer.next;
        }
        return build(buffer, 0, buffer.size());
    }
}
