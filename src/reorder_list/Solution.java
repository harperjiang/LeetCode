package reorder_list;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ArrayList<ListNode> buffer = new ArrayList<>();
        ListNode pointer = head;
        while (pointer != null) {
            buffer.add(pointer);
            pointer = pointer.next;
        }
        int size = buffer.size() / 2;
        ListNode fp = null, lp = null;
        for (int i = 0; i < size; ++i) {
            fp = buffer.get(i);
            lp = buffer.get(buffer.size() - 1 - i);
            ListNode next = fp.next;
            fp.next = lp;
            lp.next = i == (size - 1) ? null : next;
        }
        if (buffer.size() % 2 == 1) {
            lp.next = buffer.get(size );
            buffer.get(size ).next = null;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        new Solution().reorderList(n1);
    }
}
