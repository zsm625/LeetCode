package simple_100.firstday;

import java.util.LinkedList;

/**
 * 合并两个链表，从大到小的顺序
 * @author ZSM
 *
 * @time 2019年11月10日下午4:42:32
 */
public class MergeTwoLists {
	
	public ListNode mergeLists(ListNode l1,ListNode l2) {
		ListNode result = l1;
		if(l1==null) {
			return l2;
		}
		if(l2==null) {
			return l1;
		}
		if(l1.val>=l2.val) {
			 result = l2;
			 ListNode temp1 = result.next;
			 result.next=mergeLists(temp1,l1);
		}else {
			ListNode temp2 =result.next;
			result.next=mergeLists(temp2,l2);
			
		}
		
		return result;
	}
	
	public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
		
		return null;
	}
	public static void main(String[] args) {
		MergeTwoLists merge = new MergeTwoLists();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(4);
		ListNode l6 = new ListNode(4);
		l1.next=l4;
		l4.next=l5;
		l2.next=l3;
		l3.next=l6;
		ListNode lists = merge.mergeLists(l1, l2);
		while(lists!=null) {
			System.out.println(lists.val);
			ListNode temp  = lists.next;
			lists=temp;
		}
//		System.out.println(lists.next.val);
	}

}

class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x) {
		val = x;
	}
	
	public ListNode isNext() {
		
		return this.next;
	}
	public boolean hasNext() {
		if(this.next!=null) {
			return true;
		}
		return false;
	}
		
}
