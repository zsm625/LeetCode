package office66;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 *  @author ZSM
 *
 * @time 2020年2月29日下午5:45:14
 */
public class CQueue {

	/**
	 * 看到解题里面有一个是：由于频繁的删除元素和添加元素对性能有很大的影响，
	 * 所以一般不推荐使用Vector和Stack（继承自Vector）
	 * 可以采用LinkedList，根据题目的要求，希望配合队列和栈的性质去解题
	 * 添加的 时间复杂度为O（1），空间复杂度O（1）；
	 * 删除的时间复杂度为O（n），空间复杂度O（n）；
	 */
	private Stack element ;
	private Stack helper;
	public CQueue() {
		this.element = new Stack();
    }
    
    public void appendTail(int value) {
    	this.element.push(value);
    }
    
    public int deleteHead() {
    	if(this.element.isEmpty()) {
    		return -1;
    	}else {
    		this.helper = new Stack();
    		while(!this.element.isEmpty()) {
    			this.helper.push(this.element.pop());
    		}
    		int result = (int) this.helper.pop();
    		while(!this.helper.isEmpty()) {
    			this.element.push(this.helper.pop());
    		}
    		return result;
    	}
    	

    }
}
