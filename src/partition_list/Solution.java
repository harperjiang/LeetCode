package partition_list;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = null;
        ListNode head2 = null;
        ListNode tail1 = null;
        ListNode tail2 = null;
        ListNode pointer = head;
        while (pointer != null) {
            ListNode next = pointer.next;
            if (pointer.val < x) {
                if (head1 == null) {
                    head1 = pointer;
                    tail1 = pointer;
                } else {
                    tail1.next = pointer;
                }
                tail1 = pointer;
                tail1.next = null;
            } else {
                if (head2 == null) {
                    head2 = pointer;
                    tail2 = pointer;
                } else {
                    tail2.next = pointer;
                }
                tail2 = pointer;
                tail2.next = null;
            }

            pointer = next;
        }
        if (tail1 != null) {
            tail1.next = head2;
            return head1;
        } else {
            return head2;
        }
    }

}
