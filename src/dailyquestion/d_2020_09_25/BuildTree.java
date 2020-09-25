package dailyquestion.d_2020_09_25;

import java.util.HashMap;

import dailyquestion.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:你可以假设树中没有重复的元素。
 * 
 * @author zsm
 *
 *         时间：2020年9月25日
 */
public class BuildTree {

	HashMap<Integer, Integer> memo = new HashMap<>();
	int[] post;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		for (int i = 0; i < inorder.length; i++)
			memo.put(inorder[i], i);
		post = postorder;
		TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
		return root;
	}

	public TreeNode buildTree(int is, int ie, int ps, int pe) {
		if (ie < is || pe < ps)
			return null;

		int root = post[pe];
		int ri = memo.get(root);

		TreeNode node = new TreeNode(root);
		node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
		node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
		return node;
	}
}
