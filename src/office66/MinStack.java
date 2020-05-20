package office66;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 最小栈
 * 设计一个支持push、pop、top操作，并能在常数时间内检索最小元素的栈
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * 
 * @author ZSM
 *
 * @time 2020年5月12日上午9:20:07
 */
public class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;
	
	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
    }
    
    public void push(int x) {
    	stack.push(x);
    	if(minStack.isEmpty()) {
    		minStack.push(x);
    	}else {
    		Integer min = minStack.peek();
    		if(min>x) {
    			minStack.push(x);
    		}else {
    			minStack.push(min);
    		}
    	}
    	
    }
    
    public void pop() {
    	
    	if(!stack.isEmpty()) {
    		stack.pop();
    		minStack.pop();
    	}

    }
    
    public int top() {
    	if(stack.isEmpty()) {
    		return -1;
    	}
    	return stack.peek();
    }
    
    public int getMin() {
    	if(stack.isEmpty() || minStack.isEmpty()) {
    		return -1;
    	}
    	return minStack.peek();
    }
}
