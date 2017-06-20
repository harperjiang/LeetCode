package reverse_words_in_string;

public class Solution {
	public String reverseWords(String s) {
		if (s == null)
			return null;
		if (s.trim().length() == 0)
			return "";
		String[] parts = s.split("\\s+");
		String[] data = new String[parts.length];
		for (int i = 0; i <= parts.length / 2; i++) {
			data[i] = parts[data.length - 1 - i];
			data[data.length - 1 - i] = parts[i];
		}
		StringBuilder sb = new StringBuilder();
		for (String d : data) {
			sb.append(d).append(" ");
		}
		return sb.toString().trim();
	}

	public static void main(String[] args) {
		System.out.println(new Solution()
				.reverseWords("This is a good day to die"));
	}
}