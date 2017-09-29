package merge_k_sorted_list;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

	static ListNode[] build(int[][] data) {
		ListNode[] values = new ListNode[data.length];
		for (int i = 0; i < data.length; i++) {
			int[] d = data[i];
			if (d.length == 0) {
				values[i] = null;
			} else {
				ListNode head = null;
				ListNode tail = null;
				for (int x : d) {
					ListNode current = new ListNode(x);
					if (tail == null) {
						head = current;
						tail = current;
					} else {
						tail.next = current;
						tail = current;
					}
				}
				values[i] = head;
			}
		}
		return values;
	}

	@Test
	public void testMergeKLists() {
		Solution sol = new Solution();

		ListNode x;
		int[] expected;

//		x = sol.mergeKLists(new ListNode[] { null, new ListNode(1) });
//		expected = new int[] { 1 };
//		for (int i = 0; i < expected.length; i++) {
//			assertEquals(expected[i], x.val);
//			x = x.next;
//		}
//
//		x = sol.mergeKLists(build(new int[][] { new int[] { 1, 2, 2 }, new int[] { 1, 1, 2 } }));
//		expected = new int[] { 1, 1, 1, 2, 2, 2 };
//		for (int i = 0; i < expected.length; i++) {
//			assertEquals("" + i, expected[i], x.val);
//			x = x.next;
//		}
//
//		x = sol.mergeKLists(
//				build(new int[][] { new int[] { -1, 1 }, new int[] { -3, 1, 4 }, new int[] { -2, -1, 0, 2 } }));
//		expected = new int[] { -3, -2, -1, -1, 0, 1, 1, 2, 4 };
//		for (int i = 0; i < expected.length; i++) {
//			assertEquals(expected[i], x.val);
//			x = x.next;
//		}

		x = sol.mergeKLists(build(new int[][] { new int[] { -8, -7, -7, -5, 1, 1, 3, 4 }, new int[] { -2 },
				new int[] { -10, -10, -7, 0, 1, 3 }, new int[] { 2 } }));
		expected = new int[] { -10, -10, -8, -7, -7, -7, -5, -2, 0, 1, 1, 1, 2, 3, 3, 4 };
		for (int i = 0; i < expected.length; i++) {
			assertEquals("" + i, expected[i], x.val);
			x = x.next;
		}
	}

}
