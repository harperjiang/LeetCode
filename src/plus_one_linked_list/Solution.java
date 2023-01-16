package plus_one_linked_list;

import java.util.Stack;

public class Solution {
    public ListNode plusOne(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode next = head;
        while (next != null) {
            stack.push(next);
            next = next.next;
        }
        stack.peek().val++;
        boolean carry = false;
        while (!stack.isEmpty() && stack.peek().val > 9) {
            stack.pop().val = 0;
            if (!stack.isEmpty())
                stack.peek().val++;
            else carry = true;
        }
        if (carry) {
            ListNode newhead = new ListNode(1);
            newhead.next = head;
            return newhead;
        } else {
            return head;
        }
    }
}
