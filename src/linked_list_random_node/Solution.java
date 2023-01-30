package linked_list_random_node;

import java.util.Random;

public class Solution {

    int counter = 0;
    Random r = new Random(System.currentTimeMillis());
    ListNode head;
    double prob = 0;

    public Solution(ListNode head) {
        this.head = head;
        counter = 0;
        ListNode pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            counter++;
        }
        prob = ((double) 1) / counter;
    }

    public int getRandom() {
        ListNode choose = head;
        double tryprob = r.nextDouble();
        double start = prob;
        while (choose != null && start < tryprob) {
            choose = choose.next;
            start += prob;
        }
        if (choose == null) {
            choose = head;
        }
        return choose.val;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution sol = new Solution(head);
        for (int i = 0; i < 20; i++) {
            System.out.println(sol.getRandom());
        }
    }
}
