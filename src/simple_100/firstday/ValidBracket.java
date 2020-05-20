package simple_100.firstday;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 判断是否为正确的括号
 * @author ZSM
 *
 * @time 2019年11月10日下午3:02:50
 */
public class ValidBracket {
	
	/**
	 * 1、思路： 利用栈先进后出的特性，有效的括号是成对出现的， 并且不会穿插（例如：({)}这样就是无效的） 有效的括号一定是对称的，只要将对称点
	 * （将栈顶和即将入栈的一半括号进行比较， 当一致时，就将栈顶抛出，直到栈内元素为空
	 * 
	 * @author ZSM
	 * @param bracket
	 * @return
	 */
	public boolean isValid(String s) {
		boolean flag = false;
		if (s == null || s.length()%2!=0) {
			return flag;
		}
		if(s.equals("")) {
			flag=true;
			return flag;
		}
		Stack<Character> stack = new Stack<Character>();
		stack.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (!stack.isEmpty()) {
				 Character top = stack.peek();
				 char ch2 = s.charAt(i);
				if (this.twain(top, ch2)) {
					stack.pop();
					if(stack.isEmpty() && i==s.length()-1) {
						flag=true;
					}
					continue;
				}
			}
			stack.push(s.charAt(i));
		}

		return flag;
	}
	
	private boolean twain(char ch1,char ch2) {
		return ch1=='(' &&ch2==')' || ch1=='['&&ch2==']' || ch1=='{' && ch2=='}'; 
	}
	
	public static void main(String[] args) {
		ValidBracket bracket = new ValidBracket();
		System.out.println(bracket.isValidAgain("((([])))"));
	}
	
	
	
	/**
	 * 复习。第二遍
	 */
	public boolean isValidAgain(String s) {
		int k = s.length();
		if(s==null || s.length()%2!=0) {
			return false;
		}
		//入栈括号
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}') {
				if(!stack.isEmpty()) {
					Character peek = stack.peek();
					if(isOk(peek,s.charAt(i))) {
						stack.pop();
						continue;
					}else {
						return false;
					}
				}else {
					return false;
				}
			}
			stack.add(s.charAt(i));
		}
		if(stack.empty()) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean isOk(char c1,char c2) {
		return (c1=='('&&c2==')') || (c1=='['&&c2==']') || (c1=='{'&&c2=='}');
	}
	
	
	/**
	 * 使用Map
	 */
	private Map<Character,Character> map = new HashMap<>();
	public ValidBracket() {
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
	}
	
	public boolean isValid2(String s) {
		if(s==null||s.length()==0) {
			return false;
		}
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<s.length();i++) {
			char c= s.charAt(i);
			//发现右括号
			if(this.map.containsKey(c)) {
				char topElement = stack.isEmpty()?'#':stack.pop();
				if(topElement!=this.map.get(c)) {
					return false;
				}
			}else {
				//左括号
				stack.add(c);
			}
		}
		return stack.isEmpty();
		
	}
}
