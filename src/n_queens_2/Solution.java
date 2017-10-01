package n_queens_2;

class Solution {

	int n;
	int[] place;
	int counter = 0;

	public int totalNQueens(int n) {
		this.n = n;
		place = new int[n];
		counter = 0;
		solve(0);
		return counter;
	}

	protected void solve(int index) {
		if (index == n) {
			// A solution is found
			counter++;
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
}