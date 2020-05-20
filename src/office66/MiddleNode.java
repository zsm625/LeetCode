package office66;

/**
 * 链表的中间节点
 * @author ZSM
 *
 * @time 2020年3月23日下午6:12:15
 */
public class MiddleNode {
	/**
	 * 暴力，采用迭代反向利用倒数第k个节点
	 * 
	 *@author ZSM
	 * @param head
	 * @return
	 */
	public ListNode middleNode(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		int k = 0;
		ListNode temp = head;
		while(temp!=null) {
			k++;
			temp=temp.next;
		}
		int i = 1;
		//这里可以进行修改一下。使用同一个变量就可以搞定
		temp = head;
		//ListNode fast = head;
		while(i!=k/2) {
			i++;
			temp = temp.next;
		}
		return temp;
	}
	
	/**
	 * 采用快慢指针
	 * slow走一步，fast走两步
	 *@author ZSM
	 * @param head
	 * @return
	 */
	public ListNode middleNode2(ListNode head) {
		if(head==null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

}
