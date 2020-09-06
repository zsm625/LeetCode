package dailyquestion.linkedlist.d_2020_09_06;

import dailyquestion.ListNode;

/**
 * 反转链表
 * 
 * @author zsm
 *
 *     时间：2020年9月6日
 */
public class ReverseList {

	/**
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if(head==null) {
			return head;
		}
		ListNode newNode = null;
		ListNode node = head;
		while(node!=null) {
			ListNode next = node.next;
			node.next = newNode;
			newNode = node;
			node = next;
		}
		return newNode;
	}
	public static void main(String[] args) {
		ReverseList list = new ReverseList();
		ListNode head = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(3);
		ListNode head4 = new ListNode(4);
		ListNode head5 = new ListNode(5);
		head.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		ListNode node = list.reverseList(head);
		System.out.println(node.val);
	}
}
