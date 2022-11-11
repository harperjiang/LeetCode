package reverse_linked_list_2;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        int counter = 1;
        ListNode leftp = head;
        ListNode leftpp = null;
        ListNode pointer = head;
        ListNode prev = null;
        ListNode newhead = head;
        boolean exchange = false;
        while (pointer != null) {
            if (counter == left) {
                leftpp = prev;
                leftp = pointer;
                exchange = true;
                prev = pointer;
                pointer = pointer.next;
                counter++;
                leftp.next = null;
                continue;
            }
            if (counter > right) {
                leftp.next = pointer;
                if (leftpp == null) {
                    newhead = prev;
                } else {
                    leftpp.next = prev;
                }
                break;
            }
            if (exchange) {
                ListNode next = pointer.next;
                pointer.next = prev;
                prev = pointer;
                pointer = next;
            } else {
                prev = pointer;
                pointer = pointer.next;
            }
            counter++;
        }
        if (pointer == null) {
            if (leftpp != null) {
                leftpp.next = prev;
            } else {
                newhead = prev;
            }
        }
        return newhead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = new Solution().reverseBetween(head, 2, 4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
