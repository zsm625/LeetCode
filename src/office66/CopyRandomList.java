package office66;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * 
 * 看了蛮久的解题记录，才明白题目的意思，就是复制一个链表，深克隆
 * 
 * 思路：一复制所有的节点，二连接节点
 * 
 * @author ZSM
 *
 * @time 2020年6月27日下午4:43:16
 */
public class CopyRandomList {

	/**
	 * 方法一
	 * 借用map辅助，将N，N‘存在map中，
	 *@author ZSM
	 * @param head
	 * @return
	 */
	public Node1 copyRandomList(Node1 head) {
		if(head ==null ) {
			return head;
		}
		Node1 res = new Node1(head.val);
		Map<Node1,Node1> map = new HashMap<>();
		map.put(head, res);
		Node1 tempR = res;
		Node1 tempH = head;
		while(tempH.next!=null) {
			tempR.next = new Node1(tempH.next.val);
			tempH = tempH.next;
			tempR = tempR.next;
			map.put(tempH, tempR);
		}
		tempR = res;
		tempH = head;
		while(tempH!=null) {
			if(tempH.random!=null) {
				tempR.random = map.get(tempH.random);
			}
			tempR = tempR.next;
			tempH = tempH.next;
		}
		return res;
	}
	public static void main(String[] args) {
		CopyRandomList list = new CopyRandomList();
		Node1 head = new Node1(7);
		Node1 node1 = new Node1(13);
		Node1 node2 = new Node1(11);
		Node1 node3 = new Node1(10);
		Node1 node4 = new Node1(1);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		head.random= null;
		node1.random = head;
		node2.random = node4;
		node3.random = node1;
		node4.random = head;
		Node1 node = list.copyRandomList(head);
		while(node!=null) {
			System.out.println(node.val);
            node = node.next;			
		}
	}
}
class Node1{
	int val;
    Node1 next;
    Node1 random;

    public Node1(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
