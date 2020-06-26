package office66;

/**
 * 删除链表节点
 * 给定单向链表的头指针和一个要删除的节点的值，
 * 定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * @author ZSM
 *
 * @time 2020年6月26日下午4:29:28
 */
public class DeleteNode {

	/**
	 * 双指针方式
	 * pre 指向当前节点的前一个
	 * cur是当前节点
	 * 当cur.val == val时，就将pre.next = cur.next
	 * 
	 *@author ZSM
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode deleteNode(ListNode head ,int val) {
		if(head.val==val) {
			return head.next;
		}
		ListNode pre = head,cur = head.next;
		while(cur!=null && cur.val!=val) {
			pre = cur;
			cur = cur.next;
		}
		if(cur!=null) {
			pre.next = cur.next;
		}
		return head;
	}
	public static void main(String[] args) {
		DeleteNode node = new DeleteNode();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(7);
		ListNode node6 = new ListNode(9);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		ListNode node7 = node.deleteNode(node1, 3);
		while(node7!=null) {
			System.out.println(node7.val);
			node7 = node7.next;
		}
		
	}
}
