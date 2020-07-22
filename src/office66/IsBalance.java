package office66;

/**
 * 判断是否为一颗平衡二叉树
 * 输入一棵二叉树的根节点，
 * 判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，
 * 那么它就是一棵平衡二叉树。
 * @author ZSM
 *
 * @time 2020年7月22日上午11:03:30
 */
public class IsBalance {

	
	/**
	 * 递归：后序遍历+剪枝
	 * 思路：对二叉树进行后序遍历，从底至顶返回树的高度，
	 * 若判断树不是平衡树就剪枝，向上返回
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public boolean isBalance(TreeNode root) {
		if(root == null) {
			return true;
		}
		
		return isBalanceHight(root)!=-1;
	}
	public int isBalanceHight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = isBalanceHight(root.left);
		if(left==-1) return -1;
		int right = isBalanceHight(root.right);
		if(right==-1) return -1;
		return Math.abs(right-left)<2?Math.max(left, right)+1:-1;
	}
	
	public static void main(String[] args) {
		IsBalance balance = new IsBalance();
		TreeNode root = new TreeNode(3);
		TreeNode root1 = new TreeNode(9);
		TreeNode root2 = new TreeNode(20);
		TreeNode root3 = new TreeNode(15);
		TreeNode root4 = new TreeNode(17);
		root.left = root1;
		root.right = root2;
		root2.left = root3;
		root.right = root4;
		boolean b = balance.isBalance(root);
		System.out.println(b);
		
		
	}
}
