package regular_exp_matching;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	List<Character> states;
	List<Boolean> star;

	Set<Integer> currentState;
	int endState;

	public boolean isMatch(String s, String p) {
		parse(p);

		currentState = new HashSet<Integer>();
		currentState.add(0);

		endState = states.size();
		for (int i = states.size() - 1; i >= 0; i--) {
			if (star.get(i)) {
				endState--;
			} else {
				break;
			}
		}

		for (char c : s.toCharArray()) {
			if (!transit(c))
				return false;
		}
		for (int i : currentState) {
			if (i >= endState) {
				return true;
			}
		}
		return false;
	}

	protected void parse(String pattern) {
		states = new ArrayList<Character>(pattern.length());
		star = new ArrayList<Boolean>(pattern.length());
		for (char c : pattern.toCharArray()) {
			if (c == '*') {
				star.set(star.size() - 1, true);
			} else {
				states.add(c);
				star.add(false);
			}
		}
	}

	protected boolean transit(char input) {
		Set<Integer> newState = new HashSet<Integer>();
		for (Integer pos : currentState) {
			match(pos, input, newState);
		}
		currentState.clear();
		currentState.addAll(newState);
		return !newState.isEmpty();

	}

	// Return position after match, -1 if no match
	protected void match(int start, char input, Set<Integer> newState) {
		if (start == states.size()) {
			return;
		}
		if (states.get(start) == input || states.get(start) == '.') {
			newState.add(start + 1);
			if (star.get(start)) {
				newState.add(start);
			}
		}
		if (star.get(start)) {
			match(start + 1, input, newState);
		}
	}
}
