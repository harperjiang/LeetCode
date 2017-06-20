package lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private NodeList lru;

	private Map<Integer, Node> listIndex;

	private Map<Integer, Integer> map;

	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<Integer, Integer>(capacity);
		this.listIndex = new HashMap<Integer, Node>(capacity);
		this.lru = new NodeList();
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;
		if (map.size() > 1 && lru.tail.key != key) {
			Node node = listIndex.get(key);
			lru.unlink(node);
			lru.append(node);
		}

		return map.get(key);
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			map.put(key, value);
			get(key);
		} else {
			if (map.size() >= capacity) {
				Node header = lru.removeHeader();
				map.remove(header.key);
				listIndex.remove(header.key);
			}
			map.put(key, value);
			Node node = new Node();
			node.key = key;
			listIndex.put(key, node);
			lru.append(node);
		}
	}

	private class NodeList {

		Node header;

		Node tail;

		public NodeList() {
			super();
			header = null;
			tail = null;
		}

		public void unlink(Node node) {
			if (node == header && node == tail) {
				header = null;
				tail = null;
			}
			if (node == header) {
				header = node.next;
			} else if (node == tail) {
				tail = node.previous;
			}
			if (node.next != null)
				node.next.previous = node.previous;
			if (node.previous != null)
				node.previous.next = node.next;
		}

		public void append(Node newnode) {
			if (header == null) {
				header = newnode;
			} else {
				tail.next = newnode;
				newnode.previous = tail;
			}
			tail = newnode;
		}

		public Node removeHeader() {
			Node oldheader = header;
			unlink(oldheader);
			return oldheader;
		}
	}

	private class Node {
		int key;
		Node previous;
		Node next;
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(1);
		cache.set(2, 1);
		System.out.println(cache.get(2));
		cache.set(3, 2);
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
	}
}
