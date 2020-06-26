package office66;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * @author ZSM
 *
 * @time 2020年6月26日下午4:02:34
 */
public class RemoveDuplicateNodes {
	/**
	 * 移除重复的点，最简单的方式就是使用set集合，得到不重复的节点，创建一条新的链表
	 *@author ZSM
	 * @param head
	 * @return
	 */
	public ListNode removeDuplicateNodes(ListNode head) {
		Set<Integer> set = new LinkedHashSet<>();
		ListNode res = new ListNode(-1);
		ListNode temp = res;
		while(head!=null) {
			set.add(head.val);
			head = head.next;
		}
		Iterator<Integer> it = set.iterator();
		
		while(it.hasNext()) {
			ListNode node = new ListNode(it.next());
			temp.next=node;
			temp = node;
		}
		return res.next;
	}

	public static void main(String[] args) {
		RemoveDuplicateNodes nodes = new RemoveDuplicateNodes();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		ListNode node = nodes.removeDuplicateNodes(node1);
		while(node!=null) {
			System.out.println(node.val);
			node = node.next;
		}

	}
}
