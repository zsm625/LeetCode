package dailyquestion.tree.d_2020_08_08;

import dailyquestion.TreeNode;

/**
 * 面试题 04.04. 检查平衡性
 * 实现一个函数，检查二叉树是否平衡。
 * 在这个问题中，平衡树的定义如下：
 * 任意一个节点，其两棵子树的高度差不超过 1。
 * @author ZSM
 *
 * @time 2020年8月8日上午8:35:33
 */
public class IsBalance1 {

	/**
	 * DFS+加剪枝
	 * 
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public boolean isBalance(TreeNode root) {
		if(root==null) {
			return true;
		}
		return help(root)!=-1;
	}
	public int help(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int left = help(root.left);
		if(left==-1) return -1;
		int right = help(root.right);
		if(right==-1) return -1;
		return Math.abs(left-right)<2?Math.max(right, left)+1:-1;
	}
}
