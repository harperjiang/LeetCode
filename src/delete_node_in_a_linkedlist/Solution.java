package delete_node_in_a_linkedlist;

public class Solution {
    public void deleteNode(ListNode node) {
        ListNode current = node;
        ListNode prev = null;
        ListNode prev2 = null;
        while (current != null) {
            if (prev != null) {
                prev.val = current.val;
            }
            prev2 = prev;
            prev = current;
            current = current.next;
        }
        if (prev2 != null) {
            prev2.next = null;
        }
    }
}
