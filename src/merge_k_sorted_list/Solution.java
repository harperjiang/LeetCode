package merge_k_sorted_list;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

	ListNode[] lists;

	int start = 0;

	int end = 0;

	Comparator<ListNode> comp = (ListNode a, ListNode b) -> {
		if (a == b)
			return 0;
		if (a == null)
			return 1;
		if (b == null)
			return -1;
		return a.val - b.val;
	};

	public ListNode mergeKLists(ListNode[] lists) {
		this.lists = lists;

		organize();

		if (end == 0)
			return null;

		ListNode header = extract();
		ListNode pointer = header;

		while (end > 0) {
			ListNode next = extract();
			pointer.next = next;
			pointer = next;
		}

		return header;
	}

	ListNode extract() {
		ListNode header = lists[start];
		lists[start] = lists[start].next;
		if (lists[start] == null || start == end - 1 || lists[start].val > lists[start + 1].val) {
			start++;
		}
		if (start == end) {
			organize();
		}
		return header;
	}

	void organize() {
		// Sort array
		Arrays.sort(lists, comp);
		start = 0;
		// Count list size
		end = 0;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null)
				end++;
			else
				break;
		}
	}
}
