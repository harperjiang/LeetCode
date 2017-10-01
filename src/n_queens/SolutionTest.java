package n_queens;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolveNQueens() {
		Solution sol = new Solution();
		List<List<String>> result;
		
		result = sol.solveNQueens(4);
		assertEquals(2,result.size());
	}

}
