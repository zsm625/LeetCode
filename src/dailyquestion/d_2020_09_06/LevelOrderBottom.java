package dailyquestion.d_2020_09_06;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dailyquestion.TreeNode;

/**
 * 二叉树的层级遍历II
 * 从底部开始层级遍历
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * @author zsm
 *
 *     时间：2020年9月6日
 */
public class LevelOrderBottom {

	/**
	 * 时间复杂度O(N) n为节点个数
	 * 空间复杂度O(N) 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root){
		if(root==null) {
			return new ArrayList<>();
		}
		Deque<List<Integer>> deque = new LinkedList<>();
		TreeNode last = root;
		TreeNode nlast = root;
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
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
			if(node == last) {
				last = nlast;
				deque.addFirst(new ArrayList<>(list));
				list.clear();
			}
		}
		List<List<Integer>> res = new ArrayList<>();
		for (List<Integer> li : deque) {
			res.add(li);
		}
		return res;
	}
	
	public static void main(String[] args) {
		LevelOrderBottom bottom = new LevelOrderBottom();
		TreeNode root = new TreeNode(3);
		TreeNode root2 = new TreeNode(9);
		TreeNode root3 = new TreeNode(20);
		TreeNode root4 = new TreeNode(15);
		TreeNode root5 = new TreeNode(7);
		root.left = root2;
		root.right = root3;
		root3.right = root5;
		root3.left = root4;
		List<List<Integer>> list = bottom.levelOrderBottom(root);
		for (List<Integer> list2 : list) {
			System.out.println(list2);
		}
		
	}
	
}
