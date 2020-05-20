package office66;

import java.util.Stack;

/**
 * 两数之和
 * 
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
}
