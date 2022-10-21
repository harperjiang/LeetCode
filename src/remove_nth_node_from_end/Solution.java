package remove_nth_node_from_end;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode toremove = head;
        ListNode beforeremove = head;
        ListNode current = head;
        int counter = 0;
        while (current.next != null) {
            current = current.next;
            if (counter < n - 1)
                counter++;
            else {
                if (toremove == head) {
                    beforeremove = head;
                    toremove = head.next;
                } else {
                    beforeremove = toremove;
                    toremove = beforeremove.next;
                }
            }
        }
        beforeremove.next = toremove.next;
        return toremove == head ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode current = head;
        current.next = new ListNode(2);
        current = current.next;
        current.next = new ListNode(3);
        current = current.next;
        current.next = new ListNode(4);
        current = current.next;
        current.next = new ListNode(5);

        ListNode newhead = new Solution().removeNthFromEnd(head, 2);
        return;
    }
}
