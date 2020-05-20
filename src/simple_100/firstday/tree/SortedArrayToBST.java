package simple_100.firstday.tree;

/**
 * 将有序数组转成二叉搜索树
 * 根据一组升序排列的数组，建立一个二叉搜索树
 * 先找到根节点
 * @author ZSM
 *
 * @time 2020年1月15日上午10:47:53
 */
public class SortedArrayToBST {
	/**
	 * 递归
	 * 时间复杂度为O(n)
	 * 空间复杂度为O(logn)
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums == null || nums.length==0){
			return null;
		}
		return sortedArrayToBST(nums,0,nums.length);
	}
	private TreeNode sortedArrayToBST(int[] nums,int start,int end) {
		if(start >= end ) {
			return null;
		}
		//找到中间值,确定根节点
		int mid = (start+end)>>>1;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums,start,mid);
		root.right = sortedArrayToBST(nums,mid+1,end);
		return root;
	}

}
