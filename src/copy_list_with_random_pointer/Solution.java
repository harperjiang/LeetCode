package copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public Node copyRandomList(Node head) {
        Map<Node, Integer> visited = new HashMap<>();
        Node pointer = head;
        int counter = 0;
        while (pointer != null) {
            visited.put(pointer, counter++);
            pointer = pointer.next;
        }

        Map<Integer, Node> created = new HashMap<>();
        counter = 0;
        Node newhead = new Node(head.val);
        created.put(0, newhead);
        pointer = head;
        Node target = newhead;
        while (pointer != null) {
            if (pointer.random != null) {
                int val = pointer.random.val;
                int index = visited.get(pointer.random);
                target.random = created.computeIfAbsent(index, (idx) -> new Node(val));
            }
            if (pointer.next != null) {
                int val = pointer.next.val;
                target.next = created.computeIfAbsent(counter + 1, (idx) -> new Node(val));
            }
            pointer = pointer.next;
            target = target.next;
            counter++;
        }
        return newhead;
    }

    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n1.next = n2;
        n1.random = null;
        n2.next = n3;
        n2.random = n1;
        n3.next = n4;
        n3.random = n5;
        n4.next = n5;
        n4.random = n3;
        n5.random = n1;
        new Solution().copyRandomList(n1);
    }
}
