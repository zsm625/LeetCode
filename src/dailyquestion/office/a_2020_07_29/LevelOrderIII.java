package dailyquestion.office.a_2020_07_29;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dailyquestion.TreeNode;

/**
 * 从上到下z字形打印二叉树
 * 
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
 * @author ZSM
 *
 * @time 2020年7月30日上午8:32:25
 */
public class LevelOrderIII {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) {
        	return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;

    }
	
	public static void main(String[] args) {
		LevelOrderIII order = new LevelOrderIII();
		TreeNode root = new TreeNode(1);
		TreeNode root1 = new TreeNode(2);
		TreeNode root2 = new TreeNode(3);
		TreeNode root3 = new TreeNode(4);
		TreeNode root4 = new TreeNode(5);
		root.left=root1;
		root.right = root2;
		root1.left = root3;
		root2.right = root4;
		List<List<Integer>> list = order.levelOrder(root);
		for (List<Integer> list2 : list) {
			for (int list3 : list2) {
				System.out.print(list3);
			}
			System.out.println();
		}
	}
}
