package substring_concat_all_words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

	public List<Integer> findSubstring(String s, String[] words) {

		if (words == null || words.length == 0)
			return new ArrayList<Integer>();
		int wlen = words[0].length();
		int total = wlen * words.length;
		if (total > s.length())
			return new ArrayList<Integer>();

		int numWord = 0;

		Map<String, Integer> mapping = new HashMap<String, Integer>();
		int[][] counter = new int[2][words.length];
		Arrays.fill(counter[0], 0);
		for (String w : words) {
			if (!mapping.containsKey(w)) {
				mapping.put(w, mapping.size());
				numWord++;
			}
			counter[0][mapping.get(w)]++;
		}

		int[] wmatch = new int[s.length() - wlen + 1];
		Arrays.fill(wmatch, -1);
		for (int i = 0; i < wmatch.length; i++) {
			String sub = s.substring(i, i + wlen);
			if (mapping.containsKey(sub)) {
				wmatch[i] = mapping.get(sub);
			}
		}

		List<Integer> result = new ArrayList<Integer>();

		// Indices having the same modular of wlen will be processed in the same loop

		int last = s.length() - wlen + 1;
		for (int i = 0; i < wlen; i++) {
			int left = i, right = i;
			Arrays.fill(counter[1], 0);
			int wordCounter = 0;
			while (right < last) {
				// First increase right until all numbers in counter[1] are not smaller than
				// counter[0]
				while (wordCounter < numWord && right < last) {
					int current = wmatch[right];
					if (current != -1 && ++counter[1][current] == counter[0][current]) {
						wordCounter++;
					}
					right += wlen;
				}

				// Then increase left until some numbers are not matched
				while (wordCounter == numWord && left < right) {
					int current = wmatch[left];
					if (current != -1 && --counter[1][current] == counter[0][current] - 1) {
						if (right - left == wlen * words.length) {
							result.add(left);
						}
						wordCounter--;
					}
					left += wlen;
				}
			}
		}

		return result;
	}
}