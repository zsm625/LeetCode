package dailyquestion.d_2020_08_05;

import dailyquestion.TreeNode;

/**
 * 打家劫舍III
 * 
 * @author ZSM
 *
 * @time 2020年8月5日下午5:20:53
 */
public class Rob {

	/**
	 * 暴力递归 思路就是：Max（爷爷（1）+孙子（4),儿子（2））
	 * 
	 * @author ZSM
	 * @param root
	 * @return
	 */
	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int res = root.val;
		if (root.left != null) {
			res += rob(root.left.left) + rob(root.left.right);
		}
		if (root.right != null) {
			res += rob(root.right.right) + rob(root.right.left);
		}
		return Math.max(res, rob(root.left) + rob(root.right));
	}

	/**
	 * 
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public int rob2(TreeNode root) {
		int[] result = robInternal(root);
		return Math.max(result[0], result[1]);
	}
	public int[] robInternal(TreeNode root) {
		if (root == null) return new int[2];
	    int[] result = new int[2];

	    int[] left = robInternal(root.left);
	    int[] right = robInternal(root.right);

	    result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	    result[1] = left[0] + right[0] + root.val;

	    return result;
	}
}
