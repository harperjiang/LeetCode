package insertion_sort_list;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode last = head;

        ListNode pointer = head.next;
        head.next = null;
        while (pointer != null) {
            //
            ListNode next = pointer.next;
            pointer.next = null;

            if (pointer.val <= first.val) {
                pointer.next = first;
                first = pointer;
            } else if (pointer.val > last.val) {
                last.next = pointer;
                last = pointer;
            } else {
                ListNode ref = first;
                ListNode prev = first;
                while (pointer.val > ref.val) {
                    prev = ref;
                    ref = ref.next;
                }
                prev.next = pointer;
                pointer.next = ref;
            }
            pointer = next;
        }

        return first;
    }
}
