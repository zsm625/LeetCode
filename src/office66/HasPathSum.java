package office66;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 总路径和
 * 给定一个二叉树和一个目标和，
 * 判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和。
 * 如 sum=22 ，判断以下的二叉树中是否有总路径和=22的
 *            5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
        
 * @author ZSM
 *
 * @time 2020年7月7日上午9:40:58
 */
public class HasPathSum {

	/**
	 * 广度优先遍历
	 * 用两个queue，一个装node，一个装val
	 * 时间复杂度O(n)
	 * 空间复杂度O(n)
	 *@author ZSM
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hashPathSum(TreeNode root,int sum) {
		if(root==null ) {
			return false;
		}
		Queue<TreeNode> queNode = new LinkedList<>();
		Queue<Integer> queVal = new LinkedList<>();
		queNode.offer(root);
		queVal.offer(root.val);
		while(!queNode.isEmpty()) {
			TreeNode node = queNode.poll();
			int temp = queVal.poll();
			if(node.left==null && node.right ==null) {
				if(temp==sum) {
					return true;
				}
			}
			if(node.left!=null) {
				queNode.offer(node.left);
				queVal.offer(node.left.val+temp);
			}
			if(node.right!=null) {
				queNode.offer(node.right);
				queVal.offer(node.right.val+temp);
			}
		}
		return false;
	}
	
	/**
	 * 递归
	 * 时间复杂度O(n)n为树的节点数
	 * 空间复杂度O（H)，H为树的高度
	 * 最差情况下，树呈链状，N为树的高度，空间复杂度为O（N）,
	 * 平均情况下，树的高度与节点呈对数关系，为O（logN）
	 *@author ZSM
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum2(TreeNode root,int sum) {
		if(root==null) {
			return false;
		}
		if(root.left==null && root.right==null) {
			return sum==root.val;
		}
		return hasPathSum2(root.left,sum-root.val)||hasPathSum2(root.right,sum-root.val);
	}
}
