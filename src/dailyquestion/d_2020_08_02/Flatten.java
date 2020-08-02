package dailyquestion.d_2020_08_02;

import dailyquestion.TreeNode;

/**
 * 将二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 *    1
 *   / \
 *  2   5
 * / \   \
 *3   4   6
 *
 *1
 * \
 *  2
 *   \
 *    3
 *     \
 *      4
 *       \
 *        5
 *         \
 *          6
 * @author ZSM
 *
 * @time 2020年8月2日上午10:14:35
 */
public class Flatten {
	private TreeNode pre = null;
	public void flatten(TreeNode root) {
		while(root!=null) {
			if(root.left!=null) {
				root = root.right;
			}else {
				pre = root.left;
				while(pre.right!=null) {
					pre = pre.right;
				}
				pre.left = root.left;
				root.right = root.left;
				root.left = null;
				root = root.right;
			}
			
		}
	}
	
}
