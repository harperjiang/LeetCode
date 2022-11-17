package sort_list;

import java.util.List;

public class Solution {

    ListNode read(ListNode start, int size) {
        if (start == null) {
            return null;
        }
        ListNode pointer = start;
        for (int i = 1; i < size; i++) {
            if (pointer.next == null) {
                break;
            }
            pointer = pointer.next;
        }
        return pointer;
    }

    ListNode[] merge(ListNode lhead, ListNode ltail, ListNode rhead, ListNode rtail) {
        if (rhead == null) {
            return new ListNode[]{lhead, ltail};
        }
        if (rhead.val >= ltail.val) {
            ltail.next = rhead;
            return new ListNode[]{lhead, rtail};
        }
        if (lhead.val >= rtail.val) {
            rtail.next = lhead;
            return new ListNode[]{rhead, ltail};
        }
        ListNode newhead = lhead.val <= rhead.val ? lhead : rhead;
        ListNode newtail = newhead;
        ListNode lp = newhead == lhead ? lhead.next : lhead;
        ListNode rp = newhead == lhead ? rhead : rhead.next;
        while (lp != null && rp != null) {
            if (lp.val <= rp.val) {
                newtail.next = lp;
                newtail = lp;
                lp = lp.next;
            } else {
                newtail.next = rp;
                newtail = rp;
                rp = rp.next;
            }
        }
        if (lp == null && rp == null) {
            return new ListNode[]{newhead, newtail};
        } else if (lp != null) {
            newtail.next = lp;
            return new ListNode[]{newhead, ltail};
        } else {
            newtail.next = rp;
            return new ListNode[]{newhead, rtail};
        }
    }

    ListNode mergesort(ListNode head) {
        int size = 0;
        ListNode pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            size++;
        }

        ListNode newhead = head;
        ListNode prev = null;
        int mergesize = 1;
        while (mergesize < size) {
            pointer = newhead;
            while (pointer != null) {
                ListNode lhead = pointer;
                ListNode ltail = read(lhead, mergesize);
                ListNode rhead = ltail == null ? null : ltail.next;
                ListNode rtail = read(rhead, mergesize);
                ltail.next = null;
                ListNode npointer = rtail != null ? rtail.next : null;
                if (rtail != null) {
                    rtail.next = null;
                }
                // merge left and right
                ListNode[] merged = merge(lhead, ltail, rhead, rtail);
                if (pointer == newhead) {
                    newhead = merged[0];
                } else {
                    prev.next = merged[0];
                }
                prev = merged[1];
                pointer = npointer;
            }
            mergesize *= 2;
        }
        return newhead;
    }

    public ListNode sortList(ListNode head) {
        return mergesort(head);
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(-1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(0);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        ListNode result = new Solution().sortList(n1);
        return;
    }
}
