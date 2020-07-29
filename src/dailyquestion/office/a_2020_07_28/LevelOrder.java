package dailyquestion.office.a_2020_07_28;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dailyquestion.TreeNode;



/**
 * office-32 从上到下打印二叉树 II
 * 
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * @author ZSM
 *
 * @time 2020年7月29日上午8:51:57
 */
public class LevelOrder {
	
	/**
	 * 开心到飞起的层级遍历
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root){
		if(root==null) {
			return null;
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		TreeNode last = root,nlast=root;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			TreeNode node = queue.poll();
			list.add(node.val);
			if(node.left!=null) {
				queue.offer(node.left);
				nlast = node.left;
			}
			if(node.right!=null) {
				queue.offer(node.right);
				nlast = node.right;
			}
			if(node==last) {
				last = nlast;
				res.add(list);
			}
		}
		return res;
	}
	
}
