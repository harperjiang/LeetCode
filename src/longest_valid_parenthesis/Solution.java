package longest_valid_parenthesis;

import java.util.Arrays;

class Solution {
	public int longestValidParentheses(String s) {
		int longest = 0;

		int[] preceding = new int[s.length()];
		Arrays.fill(preceding, 0);
		int[] start = new int[s.length()];

		int[] stack = new int[s.length()];
		int stackPointer = 0;

		for (int i = 0; i < s.length(); i++) {
			start[i] = i + 1;
			char c = s.charAt(i);
			switch (c) {
			case '(':
				stack[stackPointer++] = i;
				break;
			case ')':
				int matched;
				if (stackPointer > 0) {
					matched = stack[--stackPointer];
					// New pair of confirmed found, compute length
					int length = 0;
					if (matched == i - 1) {
						// no contains
						length = matched == 0 ? 2 : preceding[matched - 1] + 2;
						start[i] = matched == 0 ? 0 : start[matched - 1];
					} else {
						int prevStart = start[i - 1];
						if (prevStart == matched + 1) { // Only when all contains match
							length = (matched == 0 ? 0 : preceding[matched - 1]) + i - matched + 1;
							start[i] = matched == 0 ? 0 : start[matched - 1];
						}
					}
					if (length > longest)
						longest = length;
					preceding[i] = length;
				}
			default:
				break;
			}
		}
		return longest;
	}
}
