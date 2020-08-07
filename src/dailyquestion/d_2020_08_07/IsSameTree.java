package dailyquestion.d_2020_08_07;

import dailyquestion.TreeNode;

/**
 * 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * @author ZSM
 *
 * @time 2020年8月7日上午7:35:39
 */
public class IsSameTree {
	
	/**
	 * 递归，前序遍历
	 * DFS
	 *@author ZSM
	 * @param p1
	 * @param p2
	 * @return
	 */
	public boolean isSameTree(TreeNode p,TreeNode q) {
		if(p==null && q==null){
			return true;
		}
		if(p==null || q==null) {
			return false;
		}
		if(p.val==q.val) {
			return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
		}
		return false;
	}
	
}
