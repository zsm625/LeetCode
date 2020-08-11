package dailyquestion.tree.d_2020_08_10;

import dailyquestion.TreeNode;

/**
 * 面试题 04.08. 首个共同祖先
 * 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。
 * 不得将其他的节点存储在另外的数据结构中。
 * 注意：这不一定是二叉搜索树。
 * 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
 *        3
 *       / \
 *      5   1
 *     / \ / \
 *    6  2 0  8
 *   / \
 *  7   4
 *  
 *  其中p=5，q=1
 *  res = 3
 * @author ZSM
 *
 * @time 2020年8月10日上午8:26:10
 */
public class LowestCommonAncestor {

	/**
	 * 三种情况：
	 * 在root的一左一右，直接return root
	 * 在root 的左边  将root=root.left，递归
	 * 在root 的右边，root = root.right，递归
	 *@author ZSM
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
		if(root==null) {
			return root;
		}
		if(root==p||root==q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left,p,q);
		TreeNode right = lowestCommonAncestor(root.right,p,q);
		if(left!=null && right!=null) {
			return root;
		}else if(left==null) {
			return right;
		}else {
			return left;
		}
	}
}
