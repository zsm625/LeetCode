package office66;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的深度
 * 
 * @author ZSM
 *
 * @time 2020年3月15日上午11:43:56
 */
public class MaxDepth {
	/**
	 * 递归
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int leftDepth = maxDepth(root.left);
		int rightDepth =  maxDepth(root.right);
		return Math.max(leftDepth, rightDepth)+1;
	}
	
	/**
	 * 按照层次遍历
	 * 按层打印，需要记录每层的最后节点，使用两个变量来记录，last和nlat
	 * last记录每层的最后一个节点，nlast记录当前出队列的节点的子节点，
	 * 当出队列的值等于last时，换行
	 * 
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public int maxDepth2(TreeNode root) {
		if(root==null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode last=root,nlast=root;
		int depth = 0;
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node.left!=null) {
				queue.offer(node.left);
				nlast = node.left;
			}
			if(node.right!=null) {
				queue.offer(node.right);
				nlast=node.right;
			}
			if(node==last) {
				last = nlast;
				depth++;
			}
		}
		return depth;
	}
}
