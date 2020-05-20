package simple_100.firstday.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 * 
 * @author ZSM
 *
 * @time 2020年1月1日下午5:28:35
 */
public class SymmetryBTree {

	//对称二叉树
	//左子树=右子树，方法一：递归法
	public boolean isSymmetric(TreeNode root) { 
		return isMirror(root.left,root.right);
	}
	//时间复杂度为O(n)其中n为数的结点数，因为递归要遍历所有的子树
	//空间复杂度为O(n),数的高度决定了该算法的空间复杂度
	private boolean isMirror(TreeNode t1,TreeNode t2) {
		if(t1==null&& t2==null) {
			return true;
		}
		if(t1==null || t2==null ) {
			return false;
		}
		return ((t1.val==t2.val) && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left));
	}
	
	/**
	 * 方式二：迭代
	 * 采用队列迭代
	 * 这道题的解题关键是找到对称二叉树是左右子树均要对称，那么就是左子树==右子树
	 * 时间复杂度为O(n)，要遍历整棵树，空间复杂度也为O(n)，往队列中插入n个节点
	 * 
	 */
	
	public boolean isSymmetric2(TreeNode root) {
		if(root ==null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode t1 = queue.poll();
			TreeNode t2 = queue.poll();
			if(t1==null && t2==null) {
				return true;
			}
			if(t1==null || t2==null)
				return false;
			if(t1.val!=t2.val) 
				return false;
			queue.add(t1.left);
			queue.add(t2.right);
			queue.add(t1.right);
			queue.add(t2.left);
		}
		
		return false;
	}
	
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
