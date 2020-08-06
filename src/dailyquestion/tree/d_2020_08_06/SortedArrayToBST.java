package dailyquestion.tree.d_2020_08_06;

import dailyquestion.TreeNode;

/**
 * 面试题 04.02. 最小高度树
 * 给定一个有序整数数组，
 * 元素各不相同且按升序排列，
 * 编写一个算法，创建一棵高度最小的二叉搜索树。
 * @author ZSM
 *
 * @time 2020年8月6日下午12:15:49
 */
public class SortedArrayToBST {
	/**
	 * 要使二叉搜索树的高度最小，那么就要尽可能满足左右子树都有
	 * 数组是递增的，所以，可以使mid为根节点
	 * 
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length==0) {
			return null;
		}
		return sortedArrayToBST(nums,0,nums.length-1);
	}

	private TreeNode sortedArrayToBST(int[] nums,int left,int right) {
		if(left>right) {
			return null;
		}
		//将中间的数作为根节点
		int mid = left+(right-left)/2;
		TreeNode root = new TreeNode(nums[mid]);
		//左子树
		root.left = sortedArrayToBST(nums,left,mid-1);
		//右子树
		root.right = sortedArrayToBST(nums,mid+1,right);
		return root;
	}
}
