package wildcard_matching;

import java.util.Arrays;

class Solution {
	private String p;

	int[] state;
	int[] state2;

	public boolean isMatch(String s, String p) {
		this.p = p;
		this.state = new int[p.length() + 1];
		this.state2 = new int[p.length() + 1];

		if (p.length() == 0)
			return s.length() == 0;
		state[0] = 1;
		// Find trailing *
		int end = p.length();
		while (end >= 1 && (p.charAt(end - 1) == '*'))
			end--;
		for (char c : s.toCharArray()) {
			Arrays.fill(state2, 0);
			for (int i = 0; i < state.length; i++)
				if (state[i] == 1)
					match(i, c, state2);
			int[] temp = state;
			state = state2;
			state2 = temp;
		}
		for (int i = state.length - 1; i >= end; i--) {
			if (state[i] == 1)
				return true;
		}

		return false;
	}

	protected void match(int st, char c, int[] newstate) {
		if (st >= p.length())
			return;
		if (p.charAt(st) == c || p.charAt(st) == '?') {
			newstate[st + 1] = 1;
		}
		if (p.charAt(st) == '*') {
			newstate[st] = 1; // star ignore the char
			newstate[st + 1] = 1; // star consume the char
			match(st + 1, c, newstate);// ignore this star
		}
	}
}