package all_ones;

import java.util.*;

public class AllOne {

    static class LinkedNode {
        TreeSet<String> strings = new TreeSet<>();
        int count = 1;
        LinkedNode next;
        LinkedNode prev;
    }

    Map<String, LinkedNode> query = new HashMap<>();
    LinkedNode header = null;
    LinkedNode tail = header;

    public AllOne() {

    }


    public void inc(String key) {
        if (query.containsKey(key)) {
            LinkedNode node = query.get(key);
            if (node.next == null) {
                node.next = new LinkedNode();
                node.next.count = node.count + 1;
                node.next.prev = node;
                tail = node.next;
            } else if (node.next.count != node.count + 1) {
                LinkedNode temp = new LinkedNode();
                temp.count = node.count + 1;
                temp.next = node.next;
                node.next.prev = temp;
                temp.prev = node;
                node.next = temp;
            }
            node.strings.remove(key);
            node.next.strings.add(key);
            query.put(key, node.next);

            if (node == header && node.strings.isEmpty()) {
                header = node.next;
                header.prev = null;
            }
        } else {
            if (header == null || header.count != 1) {
                LinkedNode nheader = new LinkedNode();
                if (header != null)
                    header.prev = nheader;
                nheader.next = header;
                header = nheader;
                if (tail == null)
                    tail = header;
            }
            header.strings.add(key);
            query.put(key, header);
        }
    }

    public void dec(String key) {
        LinkedNode node = query.get(key);

        node.strings.remove(key);
        if (node.count > 1 && (node.prev == null || node.prev.count != node.count - 1)) {
            LinkedNode newnode = new LinkedNode();
            newnode.count = node.count - 1;
            newnode.next = node;
            newnode.prev = node.prev;
            if (node.prev != null)
                node.prev.next = newnode;
            node.prev = newnode;
            if (node == header)
                header = newnode;
        }
        if (node.prev != null) {
            node.prev.strings.add(key);
            query.put(key, node.prev);
        } else {
            query.remove(key);
        }

        if (node.strings.isEmpty()) {
            if (node.prev != null)
                node.prev.next = node.next;
            if (node.next != null)
                node.next.prev = node.prev;
            if (node == header) header = node.next;
            if (node == tail) tail = node.prev;
        }

    }

    public String getMaxKey() {
        return (tail == null || tail.strings.isEmpty()) ? "" : tail.strings.first();
    }

    public String getMinKey() {
        return (header == null || header.strings.isEmpty()) ? "" : header.strings.first();
    }
}
