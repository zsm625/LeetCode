package dailyquestion.d_2020_08_20;

import dailyquestion.TreeNode;

/**
 * 二叉树的最小深度
 * 
 * @author Administrator
 *
 */
public class MinDepth {

	/**
	 * 递归
	 * @param root
	 * @return
	 */
	public int minDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int left = minDepth(root.left);
		int right = minDepth(root.right);
//		left==0?(right==0?left:right):left;
		if(left==0) return right+1;
		if(right==0) return left+1;
		return Math.min(right, left)+1;
	}
	
	public static void main(String[] args) {
		MinDepth depth = new MinDepth();
		TreeNode root = new TreeNode(1);
		TreeNode node = new TreeNode(2);
		root.left = node;
		int i = depth.minDepth(root);
		System.out.println(i);
	}
	
}
