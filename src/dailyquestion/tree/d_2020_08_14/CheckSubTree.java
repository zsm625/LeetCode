package dailyquestion.tree.d_2020_08_14;

import dailyquestion.TreeNode;

/**
 * 面试题 04.10. 检查子树
 * 检查子树。你有两棵非常大的二叉树：
 * T1，有几万个节点；T2，有几万个节点。
 * 设计一个算法，判断 T2 是否为 T1 的子树。
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，
 * 则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，
 * 得到的树与 T2 完全相同。
 * @author ZSM
 *
 * @time 2020年8月14日上午9:05:14
 */
public class CheckSubTree {
	/**
	 * 当找到相同的节点时，还要判断，其左子树与右子树是否相同
	 *@author ZSM
	 * @param r1
	 * @param r2
	 * @return
	 */
	public boolean checkSame(TreeNode r1,TreeNode r2) {
		if(r1==null && r2==null) {
			return true;
		}
		if(r1==null || r2==null) {
			return false;
		}
		return r1.val==r2.val && checkSame(r1.left,r2.left) && checkSame(r1.right,r2.right);
		
	}
	public boolean checkSubTree(TreeNode r1,TreeNode r2) {
		if(r1==null) {
			return r2==null;
		}
		return checkSame(r1,r2) || checkSubTree(r1.left,r2) || checkSubTree(r1.right,r2);
	}
}
