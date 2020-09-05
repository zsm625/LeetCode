package dailyquestion.linkedlist.d_2020_09_05;

import dailyquestion.ListNode;

/**
 * 两个链表的交点
 * Intersection of Two Linked Lists
 * Write a program to find the node 
 * at which the intersection of two singly linked lists begins.
 * 
 * @author zsm
 *
 *     时间：2020年9月5日
 */
public class GetIntersectionNode {

	/**
	 * 转成一个圈，就相当于有来两个快慢指针在跑，最终一定会相遇
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		 if(headA==null || headB ==null) {
			 return null;
		 }
		 ListNode a = headA;
		 ListNode b = headB;
		 while(a!=b) {
			 a = a==null?headB:a.next;
			 b = b ==null ? headA :b.next;
			 
		 }
		 return a;
	 }
}
