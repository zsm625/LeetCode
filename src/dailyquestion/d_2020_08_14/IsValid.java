package dailyquestion.d_2020_08_14;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 判断括号是否合法
 * 
 * @author ZSM
 *
 * @time 2020年8月14日上午7:54:09
 */
public class IsValid {
	/**
	 * 简单的想法：遇到每个'('时给count++，遇到')'给count--
	 * 
	 * @author ZSM
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
		if (s.length() == 0) {
			return true;
		}
		if (s.length() % 2 != 0) {
			return false;
		}
		Map<Character, Character> pairs = new HashMap<Character, Character>() {
			{
				put(')', '(');
				put(']', '[');
				put('}', '{');
			}
		};
		Deque<Character> stack = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (pairs.containsKey(ch)) {
				if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
					return false;
				}
				stack.pop();
			} else {
				stack.push(ch);
			}
		}
		return stack.isEmpty();

	}

	public static void main(String[] args) {
		IsValid valid = new IsValid();
		boolean b = valid.isValid("([)]");
		System.out.println(b);
	}
}
