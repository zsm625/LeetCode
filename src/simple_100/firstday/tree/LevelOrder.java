package simple_100.firstday.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 层级遍历
 * 
 * @author ZSM
 *
 * @time 2020年1月18日下午4:40:54
 */
public class LevelOrder {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root==null) {
			return result;
		}
		levelOrder(root,0);
		return result;
	}

	private void levelOrder(TreeNode root, int hight) {
		if(result.size()==hight) {
			result.add(new ArrayList<Integer>());
		}
		result.get(hight).add(root.val);
		if(root.left!=null) {
			levelOrder(root.left,hight+1);
		}
		if(root.right!=null) {
			levelOrder(root.right,hight+1);
		}

	}
}
