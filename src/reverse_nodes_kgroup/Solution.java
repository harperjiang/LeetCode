package reverse_nodes_kgroup;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {

    private ListNode reverse(ListNode from, int limit) {
        if (limit == 2) {
            ListNode header = from.next;
            header.next = from;
            from.next = null;
            return header;
        }
        ListNode[] slideWindow = new ListNode[3];

        slideWindow[0] = from;
        slideWindow[1] = from.next;
        slideWindow[2] = from.next.next;
        from.next = null;

        for (int i = 0; i < limit - 2; i++) {
            slideWindow[1].next = slideWindow[0];
            slideWindow[0] = slideWindow[1];
            slideWindow[1] = slideWindow[2];
            slideWindow[2] = slideWindow[2].next;
        }
        slideWindow[1].next = slideWindow[0];
        return slideWindow[1];
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1)
            return head;
        if (null == head || head.next == null)
            return head;
        int counter = 0;
        ListNode newBigHeader = null;
        ListNode pointer = head;
        ListNode scout = head;
        ListNode prevtail = null;
        while (true) {
            counter = 0;
            while (counter < k && scout != null) {
                scout = scout.next;
                counter++;
            }

            if (counter == k) {
                // Reverse the link from pointer to scout
                ListNode newheader = reverse(pointer, k);
                if (prevtail == null) {
                    newBigHeader = newheader;
                } else {
                    prevtail.next = newheader;
                }
                prevtail = pointer;
                pointer = scout;
            } else {
                // Not enough nodes, quit
                if (newBigHeader == null) {
                    newBigHeader = pointer;
                } else {
                    prevtail.next = pointer;
                }
                break;
            }
        }
        return newBigHeader;
    }

    protected ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode temp;
        ListNode prev = null;
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}