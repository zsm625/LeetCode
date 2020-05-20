package day_9_19;

import java.util.Stack;

/**
 * 两个栈实现队列 思路：用一个栈进行入栈操作，另一个栈将栈内元素进行反转
 * 
 * @author ZSM
 *
 * @time 2019年9月28日下午2:53:51
 */
public class DoubleStackBeQueue {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	/**
	 * stack1进栈(模拟入队列）
	 *@author ZSM
	 * @param node
	 */
	public void push(int node) {
		stack1.push(node);
	}

	/**
	 * 俩个栈同时模拟出队列
	 *@author ZSM
	 * @return
	 * @throws Exception
	 */
	public int pop() throws Exception {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			if (stack2.isEmpty()) {
				throw new Exception("queue is not empty");
			}
		}
		return stack2.pop();
	}
}
