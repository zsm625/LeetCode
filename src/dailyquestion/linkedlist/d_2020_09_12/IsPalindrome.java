package dailyquestion.linkedlist.d_2020_09_12;

import dailyquestion.ListNode;

/**
 * Palindrome link list 
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * @author zsm
 *
 *         时间：2020年9月12日
 */
public class IsPalindrome {
	/**
	 * 快慢指针到达中点，如果是偶数长度，那么fast不会为null，将slow往后移一位
	 * 再将fast置为head，比较快慢指针的值
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(ListNode head) {
		if(head==null) {
			return true;
		}
		ListNode fast = head,slow = head;
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if(fast!=null) {
			slow = slow.next;
		}
		fast = head;
		while(slow!=null) {
			if(slow.val!=fast.val) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return true;
	}

}
