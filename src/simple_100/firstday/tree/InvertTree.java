package simple_100.firstday.tree;

/**
 * 翻转二叉树
 * 思路很像对称二叉树
 * @author ZSM
 *
 * @time 2020年1月15日下午12:07:28
 */
public class InvertTree {
	public TreeNode invertTree(TreeNode root) {
		if(root ==null) {
			return null;
		}
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left= right;
		root.right = left;
		return root;
	}
	
}
