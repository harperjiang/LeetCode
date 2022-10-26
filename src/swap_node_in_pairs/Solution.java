package swap_node_in_pairs;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newhead = head.next;

        ListNode prev = null;
        ListNode next00 = head;
        ListNode next01 = head.next;

        while (next00 != null) {
            if (next01 == null) {
                prev.next = next00;
                next00.next = null;
                break;
            } else {
                ListNode nn00 = next01.next;
                ListNode nn01 = nn00 != null ? nn00.next : null;
                if (prev != null) {
                    prev.next = next01;
                }
                next01.next = next00;
                next00.next = null;
                prev = next00;
                next00 = nn00;
                next01 = nn01;
            }
        }
        return newhead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ListNode result = new Solution().swapPairs(head);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }
}
