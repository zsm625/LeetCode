package simple_100.firstday.tree;

/**
 * 计算左叶子的节点和
 *只要统计左叶子节点的值，那么保证当前节点的左节点不为空，同时左节点的左右节点不存在
 * @author ZSM
 *
 * @time 2020年2月28日下午7:43:13
 */
public class SumOfLeftLeaves {

	/**
	 * 内存占用过多
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public int sumOfLeftLeaves(TreeNode root) {
		
		return sumOfLeftLeaves(root,false);
	}
	
	private int sumOfLeftLeaves(TreeNode root,boolean b) {
		if(root==null) {
			return 0;
		}
		int leave = 0;
		if(b && root.left==null && root.right==null) {
			leave = root.val;
		}
		int left = sumOfLeftLeaves(root.left,true);
		int right = sumOfLeftLeaves(root.right,false);
		return left+right+leave;
		
	}
	/**
	 * 方式二
	 *@author ZSM
	 * @param root
	 * @return
	 */
	private int sum = 0;
	public int sumOfLeftLeaves2(TreeNode root) {
		if(root!=null) {
			if(root.left!=null && root.left.left==null && root.left.right==null) {
				sum+=root.left.val;
			}
			sumOfLeftLeaves2(root.left);
			sumOfLeftLeaves2(root.right);
		}
		return sum;
	}
	
}
