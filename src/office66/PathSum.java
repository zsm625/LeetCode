package office66;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中和为指定值的路径
 * 
 * @author ZSM
 *
 * @time 2020年3月26日下午5:20:30
 */
public class PathSum {

	List<List<Integer>> res = new LinkedList<>();
	List<Integer> path = new LinkedList<>();

	/**
	 * 
	 * @author ZSM
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) {
			return null;
		}
		pathSumHelp(root, sum);
		return res;
	}

	private void pathSumHelp(TreeNode root, int tar) {
		if(root==null) 
			return ;
		path.add(root.val);
		tar-=root.val;
		if(tar==0 && root.left==null && root.right==null) {
			res.add(new LinkedList<>(path));
		}
		pathSumHelp(root.left,tar);
		pathSumHelp(root.right,tar);
		path.remove(path.size()-1);
	}

	public static void main(String[] args) {
		PathSum sum = new PathSum();
	}
}
