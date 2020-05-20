package array;

/**
 * 链表反转
 * 
 * @author ZSM
 *
 * @time 2019年10月29日下午9:45:10
 */
public class ReveseLinked {
	public ListNode reverseLinked(ListNode head) {
		if(head==null||head.next==null) {
			return head;
		}
		ListNode next = head.next;
		head.next=null;
		ListNode newNode = reverseLinked(next);
		next.next=head;
		return newNode;
	}

}
class ListNode {
	int val;
	ListNode next = null;
	public ListNode(int val) {
		this.val = val;
	}
	
	
}
