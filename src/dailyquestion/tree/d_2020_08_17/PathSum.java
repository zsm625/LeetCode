package dailyquestion.tree.d_2020_08_17;

import dailyquestion.TreeNode;

/**
 * 总路径和
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。
 * 设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。
 * 注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，
 * 但是其方向必须向下(只能从父节点指向子节点方向)
 * @author ZSM
 *
 * @time 2020年8月17日上午8:56:16
 */
public class PathSum {
	private int res=0;
	public int pathSum(TreeNode root ,int sum) {
		if(root==null) {
			return 0;
		}
		 preOrder(root, sum);
	        return res;
		
	}
	
	public void dfs(TreeNode root,int sum) {
		if(root==null) {
			return;
		}
        if (root.val == sum) {
            res++;
        }
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
	}
	 private void preOrder(TreeNode root, int sum) {
	        if (root == null) {
	            return;
	        }
	        dfs(root, sum);
	        preOrder(root.left, sum);
	        preOrder(root.right, sum);
	    }
}
