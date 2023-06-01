package add_two_numbers_2;

public class Solution {
    ListNode inverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode a = head;
        ListNode b = head.next;
        head.next = null;

        while (b.next != null) {
            ListNode bnext = b.next;
            b.next = a;

            a = b;
            b = bnext;
        }
        b.next = a;
        return b;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i1 = inverse(l1);
        ListNode i2 = inverse(l2);

        ListNode ic1 = i1;
        ListNode ic2 = i2;
        ListNode reshead = null;
        ListNode res = reshead;
        int carry = 0;
        while (ic1 != null || ic2 != null) {
            if (res == null) {
                reshead = new ListNode();
                res = reshead;
            } else {
                res.next = new ListNode();
                res = res.next;
            }
            res.val = carry + (ic1==null?0:ic1.val) + (ic2 == null ? 0 : ic2.val);
            carry = res.val / 10;
            res.val %= 10;
            if (ic1 != null)
                ic1 = ic1.next;
            if (ic2 != null)
                ic2 = ic2.next;
        }
        if (carry > 0) {
            res.next = new ListNode(carry);
        }

        return inverse(reshead);
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(7);
        a1.next = new ListNode(3);
        a1.next.next = new ListNode(6);
        a1.next.next.next = new ListNode(5);

        ListNode b1 = new ListNode(3);
        b1.next = new ListNode(5);
        b1.next.next = new ListNode(7);

        new Solution().addTwoNumbers(a1, b1);
    }
}
