package dailyquestion.tree.d_2020_08_08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dailyquestion.ListNode;
import dailyquestion.TreeNode;

/**
 * 面试题 04.03. 特定深度节点链表
 * 给定一棵二叉树，设计一个算法，
 * 创建含有某一深度上所有节点的链表
 * （比如，若一棵树的深度为 D，则会创建出 D 个链表）。
 * 返回一个包含所有深度的链表的数组
 * @author ZSM
 *
 * @time 2020年8月8日上午8:04:38
 */
public class ListOfDepth {
	/**
	 * 套路，仍然是层级遍历
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public ListNode[] listOfDepth(TreeNode root) {
		if(root==null) {
			return new ListNode[0];
		}
		Queue<TreeNode> queue = new LinkedList<>();
		List<ListNode> list = new ArrayList<>();
		TreeNode last = root,nlast = root;
		ListNode node = new ListNode(-1);
		ListNode nodeT = node;
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode tnode = queue.poll();
			ListNode lnode = new ListNode(tnode.val);
			nodeT.next = lnode;
			nodeT = nodeT.next;
			if(tnode.left!=null) {
				queue.offer(tnode.left);
				nlast = tnode.left;
			}
			if(tnode.right!=null) {
				queue.offer(tnode.right);
				nlast = tnode.right;
			}
			if(tnode==last) {
				last = nlast;
				list.add(node.next);
				node = new ListNode(-1);
				nodeT = node;
			}
		}
		ListNode[] res = new ListNode[list.size()];
		for (int i=0;i<list.size();i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
