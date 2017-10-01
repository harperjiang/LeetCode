package jump_game_2;

class Solution {
	public int jump(int[] nums) {
		if (nums.length == 0 || nums.length == 1)
			return 0;
		int step = 0;
		int currentMax = 0;
		int nextMax = 0;
		int index = 0;
		while (index < nums.length) {
			while (index <= currentMax) {
				int next = nums[index] + index;
				if (next > nextMax)
					nextMax = next;
				if (nextMax >= nums.length - 1) {
					return step + 1;
				}
				index++;
			}
			currentMax = nextMax;
			step++;
		}
		return 0;
	}
}