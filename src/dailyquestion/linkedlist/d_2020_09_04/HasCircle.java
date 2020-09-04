package dailyquestion.linkedlist.d_2020_09_04;

import dailyquestion.ListNode;

/**
 * Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
 * To represent a cycle in the given linked list, 
 * we use an integer pos which represents the position (0-indexed) 
 * in the linked list where the tail connects to. 
 * If pos == -1, then there is no cycle in the linked list.
 * @author zsm
 *
 *     时间：2020年9月4日
 */
public class HasCircle {

	/**
	 * 双指针，快指针走两步，慢指针走1步，当两个指针相等时，形成环路
	 * 
	 * @param node
	 * @return
	 */
	public boolean hasCircle(ListNode node) {
		if(node==null) {
			return false;
		}
		ListNode fast = node;
		ListNode slow = node;
		while(fast.next!=null && fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
			if(slow==fast) {
				return true;
			}
		}
		return false;
	}
}
