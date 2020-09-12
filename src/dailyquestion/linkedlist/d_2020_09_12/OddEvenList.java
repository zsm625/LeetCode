package dailyquestion.linkedlist.d_2020_09_12;

import dailyquestion.ListNode;

/**
 * odd even link list
 * 翻译：1->3->5...->奇数位->2->4->6->...偶数位
 * Given a singly linked list, 
 * group all odd nodes together followed by the even nodes. 
 * Please note here we are talking about the node number 
 * and not the value in the nodes.
 * @author zsm
 *
 *     时间：2020年9月12日
 */
public class OddEvenList {
	public ListNode oddEvenList(ListNode head) {
		if(head==null) {
			return null;
		}
		ListNode odd = head,even = head.next, evenHead = even;
		while(even!=null && even.next!=null) {
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}
}
