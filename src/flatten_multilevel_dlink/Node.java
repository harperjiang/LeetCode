package flatten_multilevel_dlink;

public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {

    }
    public Node(int i) {
        val = i;
    }
}
