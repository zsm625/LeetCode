package office66;

import java.util.Stack;

/**
 * 两数之和
 * 给出两个非空的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照逆序的方式存储的，
 * 并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，
 * 则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字0之外，
 * 这两个数都不会以 0 开头。
 * @author ZSM
 *
 * @time 2020年4月14日下午5:41:27
 */
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1,ListNode l2) {
		Stack<ListNode> s1 = new Stack<>();
		Stack<ListNode> s2 = new Stack<>();
		while(l1!=null) {
			s1.push(l1);
			l1=l1.next;
		}
		while(l2!=null) {
			s2.push(l2);
			l2 = l2.next;
		}
		
		int carry = 0;
		ListNode head = null;
		while(!s1.isEmpty() || !s2.isEmpty() || carry>0) {
			int sum = carry;
			sum+=s1.isEmpty()?0:s1.pop().val;
			sum+=s2.isEmpty()?0:s2.pop().val;
			ListNode node = new ListNode(sum%10);
            node.next = head;
            head = node;
            carry = sum / 10;
		}
		return head;
	}
	
	public ListNode addTwoNumbers2(ListNode l1,ListNode l2) {
		if(l1==null) {
			return l2;
		}
		if(l2==null) {
			return l1;
		}
		ListNode headTemp = new ListNode(0);
		ListNode curr = headTemp;
		int jinwei = 0;
		/*
		 * 采用了一个哨兵法，先定义一个哨兵节点，将哨兵节点赋值给当前节点，
		 * 插入下一个节点时，先将当前节点的下一个节点指向新的节点，
		 * 然后将当前节点换成新的节点。
		 * 这是尾插法
		 */
		while(l1!=null || l2!=null) {
			int x = (l1==null?0:l1.val);
			int y = (l2==null?0:l2.val);
			int sum = x+y+jinwei;
			int val = sum%10;
			jinwei = sum/10;
			ListNode node = new ListNode(val);
			curr.next = node;
			curr = curr.next;
			l1 = l1.next;
			l2 = l2.next ;
		}
		
		
		return headTemp.next;
	}
	
	public ListNode addTwoNumbers3(ListNode l1,ListNode l2) {
		if(l1==null) {
			return l2;
		}
		if(l2==null) {
			return l1;
		}
		ListNode result = null;
		int jinwei = 0;
		/*
		 * 头插法，逆转链表
		 */
		while(l1!=null || l2!=null) {
			int x = (l1==null?0:l1.val);
			int y = (l2==null?0:l2.val);
			int sum = x+y+jinwei;
			int val = sum%10;
			jinwei = sum/10;
			ListNode node = new ListNode(val);
			node.next = result;
			result = node;
			l1 = l1.next;
			l2 = l2.next ;
		}
		
		
		return result;
	}
	
	public static void main(String[] args) {
		AddTwoNumbers numbers = new AddTwoNumbers();
		ListNode l1 = new ListNode(2);
		ListNode l12 = new ListNode(4);
		ListNode l13 = new ListNode(3);
		l1.next= l12;
		l12.next=l13;
		
		ListNode l2 = new ListNode(5);
		ListNode l22 = new ListNode(6);
		ListNode l23 = new ListNode(4);
		l2.next = l22;
		l22.next=l23;
		ListNode node = numbers.addTwoNumbers2(l1, l2);
		while(node!=null) {
			System.out.println(node.val);
			node= node.next;
		}
	}
}
