package office66;

/**
 * 二叉树的深度
 * 
 * @author ZSM
 *
 * @time 2020年3月15日上午11:43:56
 */
public class MaxDepth {
	public int maxDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int leftDepth = maxDepth(root.left);
		int rightDepth =  maxDepth(root.right);
		return Math.max(leftDepth, rightDepth)+1;
	}
}
