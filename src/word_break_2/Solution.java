package word_break_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	public List<String> wordBreak(String s, Set<String> dict) {

		List<String> results = new ArrayList<String>();

		WordTree tree = new WordTree();
		tree.build(dict);

		// Quick filtering
		if (!tree.hasChar(s)) {
			return results;
		}

		PathNode path = tree.split(s);

		if (null == path) {
			// No available
			return results;
		}
		path.build(s, results);
		return results;
	}

	private class WordNode {
		private Map<Character, WordNode> children;

		boolean isLeaf = false;

		public WordNode() {
			super();
			children = new HashMap<Character, WordNode>();
		}

		public void build(String s) {
			if (s.length() == 0) {
				this.isLeaf = true;
				return;
			}
			char c = s.charAt(0);
			if (!children.containsKey(c)) {
				children.put(c, new WordNode());
			}
			children.get(c).build(s.substring(1));
		}

		public void test(String s, int index, List<Integer> records) {
			if (isLeaf)
				records.add(index);
			if (index == s.length()) {
				return;
			}
			if (children.containsKey(s.charAt(index))) {
				children.get(s.charAt(index)).test(s, index + 1, records);
			}
		}
	}

	private class WordTree {
		WordNode header;

		private Set<Character> chars = new HashSet<Character>();

		public WordTree() {
			super();
			header = new WordNode();
		}

		public boolean hasChar(String s) {
			for (char c : s.toCharArray()) {
				if (!chars.contains(c))
					return false;
			}
			return true;
		}

		public void build(Set<String> dict) {
			for (String s : dict) {
				header.build(s);
				if (chars.size() < 26) {
					for (char c : s.toCharArray())
						chars.add(c);
				}
			}
		}

		public PathNode split(String s) {
			PathNode root = new PathNode();
			root.index = 0;
			List<PathNode> leaves = new LinkedList<PathNode>();
			leaves.add(root);

			while (!leaves.isEmpty()) {
				PathNode leaf = leaves.remove(0);
				List<Integer> newresult = new ArrayList<Integer>();
				header.test(s, leaf.index, newresult);
				for (Integer newr : newresult) {
					PathNode node = new PathNode();
					node.index = newr;
					leaf.children.add(node);
					leaves.add(node);
				}
			}
			if (!root.reachAndClean(s.length())) {
				return null;
			}
			return root;
		}
	}

	private class PathNode {
		int index;
		List<PathNode> children = new ArrayList<PathNode>();

		public boolean reachAndClean(int length) {
			if (children.isEmpty()) {
				return index == length;
			}
			Iterator<PathNode> ite = children.iterator();
			boolean any = false;
			while (ite.hasNext()) {
				PathNode child = ite.next();
				if (!child.reachAndClean(length)) {
					ite.remove();
				} else {
					any |= true;
				}
			}
			return any;
		}

		public void build(String s, List<String> res) {
			List<String> buffer = new ArrayList<String>();
			for (PathNode child : children) {
				child.build(s, 0, buffer, res);
			}
		}

		public void build(String s, int start, List<String> buffer,
				List<String> finalres) {
			if (children.isEmpty()) {
				// Leaf
				StringBuilder sb = new StringBuilder();
				for (String part : buffer)
					sb.append(part).append(" ");
				sb.append(s.substring(start));
				finalres.add(sb.toString());
			} else {
				buffer.add(s.substring(start, index));
				for (PathNode child : children)
					child.build(s, index, buffer, finalres);
				buffer.remove(buffer.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		dict.add("aaaaa");
		dict.add("aaaaaa");
		dict.add("aaaaaaa");
		dict.add("aaaaaaaa");
		dict.add("aaaaaaaaa");
		dict.add("aaaaaaaaaa");
		List<String> result = new Solution().wordBreak(s, dict);
		for (String r : result)
			System.out.println(r);
	}
}