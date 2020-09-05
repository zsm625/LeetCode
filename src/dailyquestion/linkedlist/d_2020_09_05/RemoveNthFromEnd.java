package dailyquestion.linkedlist.d_2020_09_05;

import dailyquestion.ListNode;

/**
 * 移除倒数第N个节点
 * Given a linked list, 
 * remove the n-th node from the end of list and return its head.
 * @author zsm
 *
 *         时间：2020年9月5日
 */
public class RemoveNthFromEnd {

	/**
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode start = new ListNode(-1);
		ListNode fast = start,slow = start;
		start.next = head;
		//让fast指针先走n+1步
		for(int i=1;i<=n+1;i++) {
			fast = fast.next;
		}
		while(fast!=null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return start.next;
	}
}
