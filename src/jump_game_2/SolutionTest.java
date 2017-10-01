package jump_game_2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testJump() {
		Solution sol = new Solution();
		assertEquals(2, sol.jump(new int[] { 2, 3, 1, 1, 4 }));
		assertEquals(2, sol.jump(new int[] { 3, 2, 1, 5, 3, 4, 6 }));
		assertEquals(1, sol.jump(new int[] { 4, 4, 3, 2, 0 }));
	}

}
