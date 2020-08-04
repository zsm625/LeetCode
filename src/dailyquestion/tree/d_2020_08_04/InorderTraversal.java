package dailyquestion.tree.d_2020_08_04;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import dailyquestion.TreeNode;

/**
 * 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 * @author ZSM
 *
 * @time 2020年8月4日上午9:56:10
 */
public class InorderTraversal {
	/**
	 * 先写一个递归
	 * 中序遍历 左-根-右
	 *@author ZSM
	 * @param root
	 * @return
	 */
	private List<Integer> res = new ArrayList<>();
	public List<Integer> inorderTraversal(TreeNode root) {
		if(root==null) {
			return res;
		}
		inorderTraversal(root.left);
		res.add(root.val);
		inorderTraversal(root.right);
		return res;
	}
	
	/**
	 * 方法二、使用栈结构
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal2(TreeNode root){
		if(root==null) {
			return new ArrayList<Integer>();
		}
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> deque = new LinkedList<>();
		TreeNode curr = root;
		//deque.add(curr);
		while(!deque.isEmpty() || curr!=null) {
			while(curr!=null) {
				deque.offer(curr);
				curr = curr.left;
			}
			curr = deque.pollLast();
			res.add(curr.val);
			curr = curr.right;
		}
		return res;
	}
	
	public static void main(String[] args) {
		InorderTraversal traversal = new InorderTraversal();
		TreeNode root = new TreeNode(1);
		TreeNode node1  = new  TreeNode(2);
		TreeNode node2  = new  TreeNode(3);
		root.right = node1;
		node1.left = node2;
		List<Integer> list = traversal.inorderTraversal2(root);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
