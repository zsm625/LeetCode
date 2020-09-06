package dailyquestion.linkedlist.d_2020_09_06;

import dailyquestion.ListNode;

/**
 * 移除链表中指定值的节点
 * @author zsm
 *
 *     时间：2020年9月6日
 */
public class RemoveElements {
	
	public ListNode removeElements(ListNode head,int val) {
		if(head == null) {
			return head;
		}
		while(head!=null && head.val == val ) {
			head = head.next;
		}
		ListNode node = head;
		ListNode pre = new ListNode(-1);
		pre.next = head;
		while(node!=null) {
			if(node.val==val) {
				pre.next = node.next;
			}else {
				pre = pre.next;
			}
			node = node.next;
		}
		return head;
	}
	public static void main(String[] args) {
		RemoveElements elements = new RemoveElements();
		ListNode head = new ListNode(1);
		ListNode head2 = new ListNode(1);
//		ListNode head3 = new ListNode(5);
//		ListNode head4 = new ListNode(4);
//		ListNode head5 = new ListNode(5);
		head.next = head2;
//		head2.next = head3;
//		head3.next = head4;
//		head4.next = head5;
		ListNode node = elements.removeElements(head, 1);
		
	}

}
