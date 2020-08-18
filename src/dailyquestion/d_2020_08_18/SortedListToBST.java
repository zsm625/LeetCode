package dailyquestion.d_2020_08_18;

import dailyquestion.ListNode;
import dailyquestion.TreeNode;

/**
 * 有序链表转换二叉搜索树 
 * 给定一个单链表，其中的元素按升序排序，
 *  将其转换为高度平衡的二叉搜索树。
 * 
 * @author ZSM
 *
 * @time 2020年8月18日上午10:26:56
 */
public class SortedListToBST {

	/**
	 * 先找到根节点，根节点前面的都是左子树，根节点后面的都是右子树
	 * 如何找到根节点呢？
	 * 可以使用快慢指针，当快指针到达底部时，慢指针到达中位数mid
	 * 左子树left,mid，右子树mid.next,right;
	 *@author ZSM
	 * @param head
	 * @return
	 */
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null) {
			return null;
		}
		
		return buildTree(head,null);
	}
	
	private TreeNode buildTree(ListNode left,ListNode right) {
		if(left==right) {
			return null;
		}
		ListNode mid = getMid(left,right);
		TreeNode tree = new TreeNode(mid.val);
		tree.left = buildTree(left.next,mid);
		tree.right = buildTree(mid.next,right);
		return tree;
	}
	private ListNode getMid(ListNode left,ListNode right) {
		ListNode fast = left;
		ListNode slow = left;
		while(fast!=right&& fast.next!=right) {
			fast=fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}
