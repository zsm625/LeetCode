package simple_100.firstday.tree;

/**
 * 二叉树的最大深度
 * 
 * @author ZSM
 *
 * @time 2020年1月15日上午9:39:25
 */
public class MaxDepth {
	
	/**
	 * 分别算出左右子树的高度，最后进行比较
	 * 方式一 ：递归
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
		return gainDepth(root,0);
	}
	
	private int gainDepth(TreeNode t1,int depth) {
		if(t1==null) {
			return depth;
		}
		return Math.max(gainDepth(t1.left,depth+1),gainDepth(t1.right,depth+1));
	}
	
	/**
	 * 
	 * 将上面的代码进行优化
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public int maxDepth2(TreeNode root) {
		if(root ==null) {
			return 0;
		}
		int left = maxDepth2(root.left);
		int right = maxDepth2(root.right);
		return Math.max(left, right)+1;
	}
}
