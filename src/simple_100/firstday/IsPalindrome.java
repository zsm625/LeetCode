package simple_100.firstday;

/**
 * 回文链表 ，采用的方法是快慢指针
 * 
 * @author ZSM
 *
 * @time 2020年1月11日下午4:50:40
 */
public class IsPalindrome {

	
	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		if (head == null || head.next == null) {
			return true;
		}
		ListNode prepre = null;
		ListNode pre = null;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
			pre.next = prepre;
			prepre = pre;
			
		}
		if(fast!=null) {
			slow = slow.next;
		}
		while (pre != null && slow != null) {
			if (pre.val != slow.val) {
				return false;
			}
			pre = pre.next;
			slow = slow.next;
		}

		return true;
	}

	public static void main(String[] args) {
		IsPalindrome palindrome = new IsPalindrome();
		ListNode node = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(1);
//		ListNode node4 = new ListNode(5);
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
//		node3.next = node4;
		boolean b = palindrome.isPalindrome(node);
		System.out.println(b);
	}
}
