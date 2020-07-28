package office66;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 * 
 * @author ZSM
 *
 * @time 2020年7月28日上午9:10:52
 */
public class LevelOrder {

	/**
	 * 层次遍历
	 * 按层打印，需要记录每层的最后节点，使用两个变量来记录，last和nlat
	 * last记录每层的最后一个节点，nlast记录当前出队列的节点的子节点，
	 * 当出队列的值等于last时，换行
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public int[] levelOrder(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		List<Integer> list = new ArrayList<>();
		TreeNode last = root, nlast = root;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			list.add(node.val);
			if (node.left != null) {
				queue.offer(node.left);
				nlast = node.left;
			}
			if (node.right != null) {
				queue.offer(node.right);
				nlast = node.right;
			}
			if (node == last) {
				last = nlast;
			}
		}

		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
