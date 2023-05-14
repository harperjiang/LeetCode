package flatten_multilevel_dlink;

public class Solution {
    public Node[] flatten2(Node head) {
        if(head == null) {
            return new Node[]{null,null};
        }
        Node pointer = head;
        Node prev = pointer;

        while(pointer != null) {
            if(pointer.child!=null) {
                Node[] childlist = flatten2(pointer.child);
                Node oldnext = pointer.next;
                pointer.next = childlist[0];
                childlist[0].prev = pointer;
                if(oldnext != null) {
                    childlist[1].next = oldnext;
                    oldnext.prev = childlist[1];
                }
                prev = childlist[1];
                pointer = oldnext;
            } else {
                prev = pointer;
                pointer = pointer.next;
            }
        }
        head.prev = null;
        prev.next = null;
        return new Node[]{head,prev};
    }

    public Node flatten(Node head) {
        return flatten2(head)[0];
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.child = new Node(7);
        head.next.next.child.next = new Node(8);
        head.next.next.child.next.next = new Node(9);
        head.next.next.child.next.next.next = new Node(10);
    }
}
