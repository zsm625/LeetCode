package office66;

/**
 * 判断二叉树是不是对称的
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 * @author ZSM
 *
 * @time 2020年5月31日下午5:17:45
 */
public class IsSymmetric {

	/**
	 * 递归
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if(root ==null) {
			return true;
		}
		
		
		return help(root.left,root.right);
	}
	
	private boolean help(TreeNode left,TreeNode right) {
		if(left==null && right==null) {
			return true;
		}
		if(left==null || right==null || left.val!=right.val) {
			return false;
		}
		return help(left.left,right.right)&&help(left.right,right.left);
	}
}
