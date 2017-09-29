package minimum_window_substring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public String minWindow(String s, String t) {

		Map<Character, Integer> mapping = new HashMap<Character, Integer>();
		int[][] counter = new int[2][t.length()];
		int numChar = 0;
		for (char c : t.toCharArray()) {
			if (!mapping.containsKey(c)) {
				mapping.put(c, mapping.size());
				numChar++;
			}
			counter[0][mapping.get(c)]++;
		}

		String minWindow = null;

		int left = 0, right = 0;
		int charCounter = 0;
		Arrays.fill(counter[1], 0);
		while (right < s.length()) {
			// First increase right until all chars appear
			while (charCounter < numChar && right < s.length()) {
				Integer current = mapping.get(s.charAt(right));
				if (current != null && ++counter[1][current] == counter[0][current]) {
					charCounter++;
				}
				right++;
			}
			// This is a window containing all chars, now shrink it to minimal possible
			while (charCounter == numChar && left < right) {
				Integer current = mapping.get(s.charAt(left));
				if (current != null && counter[1][current]-- == counter[0][current]) {
					charCounter--;
					String candWindow = s.substring(left, right);
					if (minWindow == null || minWindow.length() > candWindow.length()) {
						minWindow = candWindow;
					}
				}

				left++;
			}
		}
		if (minWindow == null)
			return "";
		return minWindow;
	}
}