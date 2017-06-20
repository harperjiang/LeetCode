package reverse_polish_notation;

import java.util.Stack;

public class Solution {
	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<String>();
		for (String s : tokens) {
			if (s.equals("+")) {
				if (stack.size() < 2)
					throw new IllegalArgumentException();
				String right = stack.pop();
				String left = stack.pop();
				stack.push(String.valueOf(Integer.parseInt(left)
						+ Integer.parseInt(right)));
			} else if (s.equals("-")) {
				if (stack.size() < 2)
					throw new IllegalArgumentException();
				String right = stack.pop();
				String left = stack.pop();
				stack.push(String.valueOf(Integer.parseInt(left)
						- Integer.parseInt(right)));
			} else if (s.equals("*")) {
				if (stack.size() < 2)
					throw new IllegalArgumentException();
				String right = stack.pop();
				String left = stack.pop();
				stack.push(String.valueOf(Integer.parseInt(left)
						* Integer.parseInt(right)));
			} else if (s.equals("/")) {
				if (stack.size() < 2)
					throw new IllegalArgumentException();
				String right = stack.pop();
				String left = stack.pop();
				stack.push(String.valueOf(Integer.parseInt(left)
						/ Integer.parseInt(right)));
			} else {
				stack.push(s);
			}
		}
		return Integer.parseInt(stack.pop());
	}
}
