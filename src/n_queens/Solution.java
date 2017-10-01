package n_queens;

import java.util.ArrayList;
import java.util.List;

class Solution {

	int n;
	int[] place;
	List<List<String>> solutions;

	public List<List<String>> solveNQueens(int n) {
		this.n = n;
		place = new int[n];
		solutions = new ArrayList<List<String>>();
		solve(0);
		return solutions;
	}

	protected void solve(int index) {
		if (index == n) {
			// A solution is found
			solutions.add(genSolution());
			return;
		}
		for (int i = 0; i < n; i++) {
			place[index] = i;
			if (check(index)) {
				solve(index + 1);
			}
		}
	}

	protected boolean check(int index) {
		// Check row
		int lroffset = place[index] - index;
		int rloffset = place[index] + index;
		for (int i = 0; i < index; i++) {
			if (place[i] - i == lroffset || place[i] + i == rloffset || place[i] == place[index])
				return false;
		}

		return true;
	}

	protected List<String> genSolution() {
		List<String> sol = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				sb.append(j == place[i] ? 'Q' : '.');
			}
			sol.add(sb.toString());
		}
		return sol;
	}
}