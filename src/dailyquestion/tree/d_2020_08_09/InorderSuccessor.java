package dailyquestion.tree.d_2020_08_09;

import dailyquestion.TreeNode;

/**
 * 面试题 04.06. 后继者
 *  设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * 
 * @author ZSM
 *
 * @time 2020年8月9日上午8:41:26
 */
public class InorderSuccessor {

	/**
	 * 中序遍历
	 *@author ZSM
	 * @param root
	 * @param p
	 * @return
	 */
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if(root==null) {
			return null;
		}
		TreeNode res = root,temp = root;
		while(temp!=null) {
			if(temp.val<=p.val) {
				temp = temp.right;
			}else {
				res = temp;
				temp = temp.right;
			}
			
		}
		return res.val<=p.val?res:null;
	}
}
