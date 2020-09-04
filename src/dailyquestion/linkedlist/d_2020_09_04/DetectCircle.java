package dailyquestion.linkedlist.d_2020_09_04;

import dailyquestion.ListNode;

/**
 * DetectCircle 
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null
 * @author zsm
 *
 *     时间：2020年9月4日
 */
public class DetectCircle {

	public ListNode detectCircle(ListNode node) {
		if(node == null) {
			return node;
		}
		ListNode fast = node;
		ListNode slow = node;
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow) {
				fast = node;
				while(fast!=slow) {
					fast = fast.next;
					slow = slow.next;
				}
				return fast;
			}
		}
		return null;
	}
}
