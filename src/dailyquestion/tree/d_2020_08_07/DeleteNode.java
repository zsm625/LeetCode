package dailyquestion.tree.d_2020_08_07;

import dailyquestion.TreeNode;

/**
 * 删除二叉搜索树的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，
 * 删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；如果找到了，删除它。
 * @author ZSM
 *
 * @time 2020年8月7日上午8:09:05
 */
public class DeleteNode {

	/**
	 * 删除二叉搜索树的指定节点
	 * 套路： 对二叉搜索树进行遍历+访问——>也就是找+删除
	 *      根据二叉搜索树的特点：左子树<根节点<右子树
	 *      if(root.val<key) 访问右子树
	 *      if(root.val>key) 访问左子树
	 *      当root.val==key 时，又有3种情况
	 *         1、root.left==null && root.right==null,return root;
	 *         2、root.left==null return root.right || root.right==null return root.left
	 *         3、root.left!=null && root.right!=null
	 *             找到左子树的最大值或者，右子树的最小值，然后返回
	 *@author ZSM
	 * @param root
	 * @param key
	 * @return
	 */
	public TreeNode deleteNode(TreeNode root,int key) {
		if(root==null) return null;
		//根据特点进行遍历
		if(root.val==key) {
			//当找到目标值时，有三种情况
			//1/2可以包含进来
			if(root.left==null) return root.right;
			if(root.right==null) return root.left;
			//当都不为null时
			if(root.left!=null && root.right!=null) {
				TreeNode min = getMin(root.right);
				root.val = min.val;
				root.right = deleteNode(root.right,min.val);
			}
		}
		if(root.val<key) root.right = deleteNode(root.right,key);
		
		if(root.val>key) root.left = deleteNode(root.left,key);
		
		return root;
	}
	
	public TreeNode getMin(TreeNode node) {
		//BST最左边就是最小的值
		while(node.left!=null) node = node.left;
		return node;
	}
}
