package dailyquestion.d_2020_09_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dailyquestion.TreeNode;

/**
 * 637. 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * @author zsm
 *
 *     时间：2020年9月12日
 */
public class AverageOfLevels {

	/**
	 * 
	 * @param root
	 * @return
	 */
	public List<Double> averageOfLevels(TreeNode root){
		List<Double> res = new ArrayList<>();
		double caculate = 0.0;
		int count = 0;
		if(root==null) {
			return res;
		}
		TreeNode last = root;
		TreeNode nlast = root;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			caculate+=node.val;
			count++;
			if(node.left!=null) {
				queue.offer(node.left);
				nlast = node.left;
			}
			if(node.right!=null) {
				queue.offer(node.right);
				nlast = node.right;
			}
			if(node==last) {
				res.add(caculate/count);
				last = nlast;
				count=0;
				caculate = 0.0;
			}
		}
		return res; 
	}
}
