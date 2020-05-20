package office66;

/**
 * 翻转等价二叉树
 * 
 * @author ZSM
 *
 * @time 2020年2月25日下午6:43:06
 */
public class FlipEquive {

	/**
	 * 思路：
	 * root1和root2想等的话，两个根节点值相等，那么只需要检查它们的孩子是不是相等就可以了
	 * 存在三种情况：
	 * 1、如果root1或者root2是null，那么只有在它们都为null的情况下才等价
	 * 2、如果root1和root2的值不相等，那么这两个二叉树一定不等价
	 * 3、如果以上条件都不满足，说明root1和root2的值相等，
	 *    还需要去判断root1的孩子节点是不是跟root2的孩子节点相当，
	 *    因为可以做翻转操作，所以这里有两种情况需要去判断
	 * 
	 *@author ZSM
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean flipEquive(TreeNode root1, TreeNode root2) {
		if(root1==null && root2==null) {
			return true;
		}else if(root1==null||root2==null || root1.val!=root2.val) {
			return false;
		}else {
			return (flipEquive(root1.left,root2.right) && flipEquive(root1.right,root2.left))||(flipEquive(root1.left,root2.left)&&flipEquive(root1.right,root2.right));
		}
		
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
