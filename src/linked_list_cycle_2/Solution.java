package linked_list_cycle_2;

import java.util.List;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        if(head.next == head) {
            return head;
        }
        ListNode singlehead = head;
        ListNode doublehead = head;

        singlehead = singlehead.next;
        doublehead = doublehead.next;
        if (doublehead != null) {
            doublehead = doublehead.next;
        }

        int n = 1;
        while (singlehead != null && doublehead != null && singlehead != doublehead) {
            singlehead = singlehead.next;
            doublehead = doublehead.next;
            if (doublehead != null) {
                doublehead = doublehead.next;
            }
            n++;
        }
        if (singlehead != null && singlehead == doublehead) {
            // Loop meet
            ListNode meetpoint = singlehead;
            ListNode meetnext = singlehead.next;
            int x = 0;
            int y = 0;
            singlehead = head.next;
            doublehead = head.next.next;
            while (singlehead != null && doublehead != null && singlehead != doublehead) {
                if (singlehead == meetpoint) {
                    x++;
                }
                if (doublehead == meetpoint || doublehead == meetnext) {
                    y++;
                }
                singlehead = singlehead.next;
                doublehead = doublehead.next.next;
            }
            int b = n / (y - x);
            ListNode pointer = head;
            for (int i = 0; i < b; ++i) {
                pointer = pointer.next;
            }
            ListNode pointer2 = head;
            while (pointer != pointer2) {
                pointer = pointer.next;
                pointer2 = pointer2.next;
            }
            return pointer;
        } else {
            // If any of these is null, there's no cycle
            return null;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(0);
//        ListNode n4 = new ListNode(-4);
        n1.next = n1;
//        n2.next = n1;
//        n3.next = n4;
//        n4.next = n2;
        System.out.println(new Solution().detectCycle(n1));
    }
}
