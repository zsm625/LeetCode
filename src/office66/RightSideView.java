package office66;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，想象自己站在它的右侧， 按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 
 * @author ZSM
 *
 * @time 2020年4月22日下午5:51:02
 */
public class RightSideView {

	/**
	 * 思路： 广度优先遍历BFS
	 * 记录每一层的最后一个元素
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root==null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				TreeNode node = queue.poll();
				if(node.left!=null) {
					queue.offer(node.left);
				}
				if(node.right!=null) {
					queue.offer(node.right);
				}
				if(i==size-1) {
					res.add(node.val);
				}
				
			}
		}
		return res;
	}
	
	private List<Integer> res = new ArrayList<>();
	/**
	 * 深度优先遍历
	 * 从根节点-->右节点-->左节点依次遍历，加入每一深度的遍历的第一个节点
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView2(TreeNode root){
		dfs(root,0);
		return res;
		
	}
	private void dfs(TreeNode root,int depth) {
		if(root==null) {
			return;
		}
		if(depth==res.size()) {
			res.add(root.val);
		}
		depth++;
		dfs(root.right,depth);
		dfs(root.left,depth);
	}
}
