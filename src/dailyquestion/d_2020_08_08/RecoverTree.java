package dailyquestion.d_2020_08_08;

import java.util.ArrayList;
import java.util.List;

import dailyquestion.TreeNode;

/**
 * 恢复二叉搜索树
 * 二叉搜索树中的两个节点被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树。
 * @author ZSM
 *
 * @time 2020年8月8日上午7:23:21
 */
public class RecoverTree {

	/**
	 * 显示中序遍历
	 *  二叉搜索树的中序遍历是一个递增的序列；
	 *  根据题意，有两个节点被错误交换
	 *  因此得到的递增序列一定有两个数是不满足递增的，找到这两个数
	 *  然后进行交换
	 *  可以通过一个List来维护递增数组
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public TreeNode recoverTree(TreeNode root) {
		if(root==null) return root;
		List<Integer> nums = new ArrayList<>();
		//中序遍历
		inorder(root,nums);
		//找到两个被交换的节点值
		int[] values = findExchangeValue(nums);
		//交换恢复
		swapValue(root,values);
		return root;
	}
	//中序遍历
	public void inorder(TreeNode root,List<Integer> nums) {
		if(root==null) return;
		inorder(root.left,nums);
		nums.add(root.val);
		inorder(root.right,nums);
	}
	//找到两个被换的节点值
	public int[] findExchangeValue(List<Integer> nums){
		int x = -1;
		int y = -1;
		for(int i=0;i<nums.size()-1;i++) {
			if(nums.get(i)>nums.get(i+1)) {
				y = nums.get(i+1);
				if(x==-1) {
					x = nums.get(i);
				}else {
					break;
				}
				
			}
		}
		return new int[]{x,y};
	}
	
	public void swapValue(TreeNode root,int[] values) {
		if(root==null) return;
		if(root!=null) {
			if(root.val==values[0] || root.val==values[1]) {
				root.val = root.val==values[0]?values[1]:values[0];
			}
		}
		swapValue(root.left,values);
		swapValue(root.right,values);
	}
}
