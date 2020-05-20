package office66;

/**
 * 链表中的倒数第k个元素
 * @author ZSM
 *
 * @time 2020年3月16日下午12:27:10
 */
public class GetKthFromEnd {

	/**
	 * 典型的快慢指针走法
	 *@author ZSM
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode getKthFromEnd(ListNode head,int k) {
		if(head ==null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null) {
			fast = fast.next;
			//设置fast先走k步
			if(k==0) {
				slow = slow.next;
			}else {
				k--;
			}
			
		}
		if(k!=0) {
			return null;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		GetKthFromEnd end = new GetKthFromEnd();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ListNode node = end.getKthFromEnd(node1, 2);
		System.out.println(node.val);
	}
}

class ListNode{
	int val ;
	ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
}
