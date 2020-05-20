package simple_100.firstday.tree;

/**
 * 合并二叉树
 * 
 * @author ZSM
 *
 * @time 2020年1月15日上午11:30:56
 */
public class MergeBinaryTree {

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		TreeNode root = null;
		if (t1 == null)
			return t2;

		if (t2 == null)
			return t1;
		root = new TreeNode(t1.val+t2.val);
		root.left = mergeTrees(t1.left,t2.left);
		root.right = mergeTrees(t1.right,t2.right);
		return root;
	}
	
	/**
	 * 优化上面的代码，我重新建了一棵树
	 * 这个方法则是在一颗树上做操作
	 * 时间复杂度为O(n)，n为节点数最小的树
	 * 空间复杂度为O(n),最坏情况下，要递归n层，需要n层栈
	 *@author ZSM
	 * @param t1
	 * @param t2
	 * @return
	 */
	public TreeNode mergeTrees2(TreeNode t1,TreeNode t2) {
		if(t1 ==null ) {
			return t2;
		}
		if(t2==null) {
			return t1;
		}
		t1.val+= t2.val;
		t1.left = mergeTrees2(t1.left,t2.left);
		t1.right = mergeTrees2(t1.right,t2.right);
		return t1;
		
	}
}
