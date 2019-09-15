package day_9_15;


/**
 * 合并二叉树
 * 
 * 思路:两棵树同时递归，B树更新A树
 *     如果A、B子树都为空，返回为null；
 *     如果A子树为空，B不为空，则返回B子树，反之（将第一种情况包含进去了）
 *     如果A、B子树均不为空，A子树的值+B子树的值
 * @author ZSM
 *
 * @time 2019年9月15日下午5:20:33
 */
public class MargeTrees {

	public TreeNode margeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return t2;
		}
		if (t2 == null) {
			return t1;
		}
		
		t1.val=t1.val+t2.val;
		t1.left=margeTrees(t1.left,t2.left);
		t1.right=margeTrees(t1.right,t2.right);

		return t1;

	}
	

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
