package day_9_19;

import java.util.ArrayList;
import java.util.List;

/**
 * 从尾到头打印链表
 * 
 * @author ZSM
 *
 * @time 2019年9月27日上午9:59:27
 */
public class PrintList {
	
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		if(listNode!=null) {
			list.addAll(printListFromTailToHead(listNode.next));
			list.add(listNode.val);
		}
		
		return list;
		
	}
	
	public static void main(String[] args) {
		ListNode first = new ListNode(10);
		ListNode two = new ListNode(0);
		ListNode three = new ListNode(23);
		ListNode four = new ListNode(12);
		ListNode five = new ListNode(22);
		first.next=two;
		two.next=three;
		three.next=four;
		four.next=five;
		
		ArrayList<Integer> list = new PrintList().printListFromTailToHead(first);
		System.out.println(list);
		
	}

}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}
