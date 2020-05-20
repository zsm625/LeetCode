package simple_100.firstday;

import java.util.LinkedHashMap;

/**
 * 反转链表
 * 
 * @author ZSM
 *
 * @time 2020年1月11日上午10:57:14
 */
public class ReverseLinkedList {
	/**
	 * 迭代
	 * 时间复杂度为O(n) n为链表长度
	 * 空间复杂度为O(1)
	 *@author ZSM
	 * @param node
	 * @return
	 */
	public ListNode reverseList(ListNode node) {
		ListNode curr = node;
		ListNode prev = null;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}

		return prev;
	}
	
	/**
	 * 递归
	 *@author ZSM
	 * @param head
	 * @return
	 */
	public ListNode reverseList2(ListNode head) {
		if(head==null||head.next==null) {
			return head;
		}
		ListNode nextN = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		return nextN;
	}

	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();
		ListNode node = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		ListNode reverseList = list.reverseList2(node);
		while(reverseList!=null) {
			System.out.println(reverseList.val);
			reverseList=reverseList.next;
		}
	}

}

