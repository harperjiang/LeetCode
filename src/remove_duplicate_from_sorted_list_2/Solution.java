package remove_duplicate_from_sorted_list_2;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode pointer = head;
        ListNode candid = null;
        boolean validCandid = true;
        ListNode newHeader = null;
        ListNode lastValid = null;
        while (pointer != null) {
            ListNode next = pointer.next;
            if (candid != null) {
                if (pointer.val == candid.val) {
                    validCandid = false;
                } else {
                    if (validCandid) {
                        if (newHeader == null) {
                            newHeader = candid;
                            lastValid = newHeader;
                            lastValid.next = null;
                        } else {
                            lastValid.next = candid;
                            candid.next = null;
                            lastValid = candid;
                        }
                    }
                    candid = pointer;
                    validCandid = true;
                }
            } else {
                candid = pointer;
            }
            pointer = next;
        }
        if (validCandid) {
            if (newHeader == null) {
                newHeader = candid;
                candid.next=null;
            } else {
                lastValid.next = candid;
                candid.next = null;
            }
        }

        return newHeader;
    }

    public static void main(String[] args) {
        ListNode header = new ListNode(1);
//        header.next = new ListNode(2);
//        header.next.next = new ListNode(3);
//        header.next.next.next = new ListNode(3);
//        header.next.next.next.next = new ListNode(4);
//        header.next.next.next.next.next = new ListNode(4);
//        header.next.next.next.next.next.next = new ListNode(5);
        ListNode newHeader = new Solution().deleteDuplicates(header);
        ListNode p = newHeader;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
