package day_9_19;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 思路：根据前序遍历可得出树的根节点是第一个数字 根据后序遍历的特点可知根节点将左右子树分开，所以可以通过相同的的遍历路径，找出左子树和右子树
 * 
 * @author ZSM
 *
 * @time 2019年9月27日下午2:40:18
 */
public class ReConstructBTree {
	Map<Integer, Integer> indexForInOrder = new HashMap<Integer, Integer>();

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		for (int i = 0; i < in.length; i++) {
			indexForInOrder.put(in[i], i);
		}
		return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
	}

	/**
	 * 参考牛客上其他人的做法，
	 * 根据中序遍历将树从根节点分成左右子树，然后递归子树
	 * 
	 * @author Others
	 * @param pre
	 * @param in
	 * @return
	 */
	public TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
		if (pre.length == 0 || in.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(pre[0]);
		// 在中序中找到前序的根
		for (int i = 0; i < in.length; i++) {
			if (in[i] == pre[0]) {
				// 左子树，注意 copyOfRange 函数，左闭右开
				root.left = reConstructBinaryTree1(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
				// 右子树，注意 copyOfRange 函数，左闭右开
				root.right = reConstructBinaryTree1(Arrays.copyOfRange(pre, i + 1, pre.length),
						Arrays.copyOfRange(in, i + 1, in.length));
				break;
			}
		}
		return root;
	}

	private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
		if (preL > preR) {
			return null;
		}
		TreeNode root = new TreeNode(pre[preL]);
		// 找到根节点在中序遍历中的索引
		int inIndex = indexForInOrder.get(root.val);
		int leftSize = inIndex - inL - 1;
//		System.out.println("left:" + leftSize);
		root.left = reConstructBinaryTree(pre, preL + 1, preR+leftSize, inL);
		if (leftSize <= 0) {
			root.right = reConstructBinaryTree(pre, preL + 1, preR, inL + leftSize + 1);
		}
		return root;
	}

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 0, 7, 3, 5, 6, 8 };
		int[] in = { 0, 4, 7, 2, 1, 5, 3, 8, 6 };
		ReConstructBTree re = new ReConstructBTree();
		TreeNode tree1 = re.reConstructBinaryTree(pre, in);
//		Map<Integer, Integer> map = re.indexForInOrder;
//		for (int i : map.keySet()) {
//			System.out.println(i + " ");
//		}
		
		String str;
		tree1.preIterator(tree1);

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	// 遍历方法
	public void preIterator(TreeNode node) {
		if (node == null) {
			return;
		} else {
			System.out.println("preIterator Data:" + node.val);
			preIterator(node.left);
			preIterator(node.right);
		}
	}
}
