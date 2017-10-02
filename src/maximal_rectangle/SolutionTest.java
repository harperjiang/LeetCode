package maximal_rectangle;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolution() {
		Solution sol = new Solution();

		assertEquals(6,
				sol.maximalRectangle(
						new char[][] { new char[] { '1', '0', '1', '0', '0' }, new char[] { '1', '0', '1', '1', '1' },
								new char[] { '1', '1', '1', '1', '1' }, new char[] { '1', '0', '0', '1', '0' } }));
		assertEquals(4, sol.maximalRectangle(new char[][] { new char[] { '1' }, new char[] { '0' }, new char[] { '1' },
				new char[] { '1' }, new char[] { '1' }, new char[] { '1' }, new char[] { '0' } }));

		assertEquals(10,
				sol.maximalRectangle(new char[][] { "0110010101".toCharArray(), "0010101010".toCharArray(),
						"1000010110".toCharArray(), "0111111010".toCharArray(), "0011111110".toCharArray(),
						"1101011110".toCharArray(), "0001100010".toCharArray(), "1101100111".toCharArray(),
						"0101101011".toCharArray() }));
	}
}
