package office66;

/**
 * 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 *    a1-->a2-->c1-->c2-->c3
 *b1-->b2-->b3/    
 *这两条链表的公共节点就是c1
 * @author ZSM
 *
 * @time 2020年7月4日上午12:02:41
 */
public class GetIntersectionNode {
	/**
	 * 双指针
	 * 两个指针同时出发，最后一起到达终点，、
	 * 再次进入新一轮循环，当两个指针第一次到达同一点时，得到公共节点
	 *@author ZSM
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) {
        	return null;
        }
        ListNode node1 = headA,node2 = headB;
        while(node1!=node2) {
        	node1 = node1==null?headB:node1.next;
        	node2 = node2==null?headA:node2.next;
        }
        return node1;
    } 

}
