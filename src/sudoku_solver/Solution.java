package sudoku_solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	char[][] board;

	public void solveSudoku(char[][] board) {
		this.board = board;

		List<Integer[]> idx = new ArrayList<Integer[]>();
		List<Integer[]> possible = new ArrayList<Integer[]>();
		List<Integer> pointer = new ArrayList<Integer>();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					idx.add(new Integer[] { i, j });
				}
			}
		}
		int current = 0;
		boolean fwd = true;
		while (current < idx.size()) {
			Integer[] pos = idx.get(current);
			if (!fwd) {
				int pnt = pointer.get(current);
				Integer[] psb = possible.get(current);
				pnt++;
				if (psb[pnt] != -1) {
					fwd = true;
					pointer.set(current, pnt);
					board[pos[0]][pos[1]] = (char) ('1' + possible.get(current)[pointer.get(current)]);
					current++;
				} else {
					board[pos[0]][pos[1]] = '.';
					current--;
				}
			} else {
				Integer[] p = possible(pos[0], pos[1]);

				if (p[0] == -1) {
					// no choice, fallback
					board[pos[0]][pos[1]] = '.';
					fwd = false;
					current--;
				} else {
					if (possible.size() > current) {
						possible.set(current, p);
						pointer.set(current, 0);
					} else {
						possible.add(p);
						pointer.add(0);
					}
					board[pos[0]][pos[1]] = (char) ('1' + p[0]);
					current++;
				}
			}
		}
	}

	protected Integer[] possible(int i, int j) {
		int[] all = new int[9];
		Arrays.fill(all, 1);

		int blocki = i / 3;
		int blockj = j / 3;

		for (int idx = 0; idx < 9; idx++) {
			if (board[i][idx] != '.') {
				all[board[i][idx] - '1'] = 0;
			}
			if (board[idx][j] != '.') {
				all[board[idx][j] - '1'] = 0;
			}
			char inblock = board[blocki * 3 + idx / 3][blockj * 3 + idx % 3];
			if (inblock != '.') {
				all[inblock - '1'] = 0;
			}
		}

		Integer[] cand = new Integer[9];
		Arrays.fill(cand, -1);
		int pointer = 0;
		for (int idx = 0; idx < 9; idx++) {
			if (all[idx] == 1)
				cand[pointer++] = idx;
		}
		return cand;
	}
}
