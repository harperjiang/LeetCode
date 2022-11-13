package populating_next_right_pointers_in_each_node;

import java.util.LinkedList;

public class Solution {
    public Node connect(Node root) {
        LinkedList<Node> buffer = new LinkedList<>();
        buffer.add(root);
        while (!buffer.isEmpty()) {
            int size = buffer.size();
            Node prev = null;
            for (int i = 0; i < size; ++i) {
                Node node = buffer.pop();
                if (node != null) {
                    if (prev != null) {
                        prev.next = node;
                    }
                    prev = node;
                    if (node.left != null) {
                        buffer.add(node.left);
                    }
                    if (node.right != null) {
                        buffer.add(node.right);
                    }
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right= new Node(5);
        root.right.left = new Node(6);
        root.right.right= new Node(7);
        new Solution().connect(root);
        return;
    }
}
