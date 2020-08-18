package dailyquestion;

/**
 * ListNode 定义单向链表
 * 
 * @author ZSM
 *
 * @time 2020年8月8日上午8:07:03
 */
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
