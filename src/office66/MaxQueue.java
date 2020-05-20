package office66;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * @author ZSM
 *
 * @time 2020年4月8日上午11:40:59
 */
public class MaxQueue {
	private Queue<Integer> queue ;
	private Deque<Integer> deque;
	/**
	 * 用一个队列，一个双端队列做辅助
	 */
	public MaxQueue() {
		queue = new LinkedList<>();
		deque = new LinkedList<>();
		
	}

	/**
	 * 以后要习惯使用三木运算
	 *@author ZSM
	 * @return
	 */
	public int max_value() {
		return queue.size()<0?-1:deque.peek();
	}

	public void push_back(int value) {
		//value入队
		queue.offer(value);
		while(deque.size()>0 && deque.getLast()<value) {
			deque.pollLast();
		}
		deque.offer(value);
		
	}

	public int pop_front() {
		Integer first = queue.size()>0? queue.poll():-1;
		if(deque.contains(first)) {
			deque.remove(first);
		}
		return first;
	}

}
