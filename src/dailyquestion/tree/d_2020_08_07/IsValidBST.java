package dailyquestion.tree.d_2020_08_07;

import dailyquestion.TreeNode;

/**
 * 合法二叉搜索树
 *  实现一个函数，检查一棵二叉树是否为二叉搜索树。
 * @author ZSM
 *
 * @time 2020年8月7日上午8:40:42
 */
public class IsValidBST {

	/**
	 * 左子树<根节点<右子树
	 *    需要注意的细节是：应该是整颗左子树节点值都<根节点<整颗右子树节点
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root,null,null);
	}
	public boolean isValidBST(TreeNode root,TreeNode min,TreeNode max) {
		if(root==null) {
			return true;
		}
		if(min!=null && root.val<=min.val) return false;
		if(max!=null && root.val>=max.val) return false;
		return isValidBST(root.left,min,root)&&isValidBST(root.right,root,max);
	}
	public static void main(String[] args) {
		IsValidBST bst = new IsValidBST();
		TreeNode root = new TreeNode(5);
		TreeNode root2 = new TreeNode(1);
		TreeNode root3 = new TreeNode(4);
		TreeNode root4 = new TreeNode(3);
		TreeNode root5 = new TreeNode(6);
		root.left=root2;
		root.right = root3;
		root3.left = root4;
		root3.right = root5;
		boolean b = bst.isValidBST(root);
		System.out.println(b);
	}
}
