package n_queens_2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolveNQueens() {
		Solution sol = new Solution();

		assertEquals(2, sol.totalNQueens(4));
	}

}
