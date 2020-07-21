package office66;

import java.util.LinkedList;
import java.util.List;

/**
 * 不同的二叉搜索树ＩＩ
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * 
 * @author ZSM
 *
 * @time 2020年7月21日上午9:29:22
 */
public class GenerateTrees {
	
	/**
	 * 递归
	 *@author ZSM
	 * @param n
	 * @return
	 */
	public List<TreeNode> generateTrees(int n){
		if(n<=0) {
			return new LinkedList<>();
		}
		return generateTrees(1,n);
	}

	/**
	 * 递归：1-n能形成的所有二叉搜索树，根据搜索树的特点：左子树<根节点<右子树
	 * 由此可知，当根节点为i时，1--i-1是左子树，i+1--n是右子树
	 *@author ZSM
	 * @param start
	 * @param end
	 * @return
	 */
	public List<TreeNode> generateTrees(int start,int end){
		List<TreeNode> allTrees = new LinkedList<>();
		if(start>end) {
			allTrees.add(null);
			return allTrees;
		}
		for(int i=start;i<=end;i++) {
			List<TreeNode> leftTrees = generateTrees(start,i-1);
			List<TreeNode> rightTrees = generateTrees(i+1,end);
			
			for(TreeNode left : leftTrees) {
				for (TreeNode right : rightTrees) {
					TreeNode currTree = new TreeNode(i);
					currTree.left=left;
					currTree.right = right;
					allTrees.add(currTree);
				}
			}
		}
		return allTrees;
	}
}
