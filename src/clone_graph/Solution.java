package clone_graph;

public class Solution {

    Node clone(Node input, Node[] buffer) {
        if(null==input) {
            return null;
        }
        if (buffer[input.val] != null) {
            return buffer[input.val];
        }
        Node root = new Node(input.val);
        buffer[input.val] = root;

        for (Node n : input.neighbors) {
            if (n != null)
                root.neighbors.add(clone(n, buffer));
        }
        return root;
    }

    public Node cloneGraph(Node node) {
        return clone(node, new Node[101]);
    }
}
