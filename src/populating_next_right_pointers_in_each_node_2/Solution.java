package populating_next_right_pointers_in_each_node_2;

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
}
