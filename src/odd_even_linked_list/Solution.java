package odd_even_linked_list;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head==null||head.next == null) {
            return head;
        }
        ListNode oddhead = head;
        ListNode evenhead = head.next;
        ListNode remainhead = evenhead.next;
        ListNode[] tails = new ListNode[]{oddhead, evenhead};
        oddhead.next = null;
        evenhead.next = null;
        int counter = 0;
        while (remainhead != null) {
            ListNode next = remainhead.next;
            int index = (counter++) % 2;
            ListNode tail = tails[index];
            tail.next = remainhead;
            remainhead.next = null;
            tails[index] = remainhead;
            remainhead = next;
        }
        tails[0].next = evenhead;
        return oddhead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new Solution().oddEvenList(head);
    }
}
