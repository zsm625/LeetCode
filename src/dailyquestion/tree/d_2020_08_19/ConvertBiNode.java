package dailyquestion.tree.d_2020_08_19;

import dailyquestion.TreeNode;

/**
 * 面试题 17.12. BiNode
 * 二叉树数据结构TreeNode可用来表示单向链表
 * （其中left置空，right为下一个链表节点）。
 * 实现一个方法，把二叉搜索树转换为单向链表，
 * 要求依然符合二叉搜索树的性质，转换操作应是原址的，
 * 也就是在原始的二叉搜索树上直接修改。
 * 返回转换后的单向链表的头节点。
 * @author ZSM
 *
 * @time 2020年8月19日上午8:46:06
 */
public class ConvertBiNode {
	
	private TreeNode head = new TreeNode(-1);
	private TreeNode pre = null;
	/**
	 * 将二叉树转为链表，在原址上操作，实际上仍然是一颗二叉树，只是将左子树都置为null，
	 * 将原树中的左子树修改到右子树中
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public TreeNode convertBiNode(TreeNode root) {
		if(root==null) {
			return null;
		}
		inorder(root);
		return head.right;
    }
	public void inorder(TreeNode root) {
		if(root==null) return;
		inorder(root.left);
		if(pre==null) {
			pre = root;
			head.right = root;
		}else {
			pre.right = root;
			pre = root;
		}
		root.left = null;
		inorder(root.right);
	}

}
