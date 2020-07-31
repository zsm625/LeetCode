package dailyquestion.office.a_2020_07_31;

/**
 * 二叉树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 * @author ZSM
 *
 * @time 2020年7月31日上午8:57:48
 */
public class VerifyPostorder {

	/**
	 * 递归分治
	 * 二叉搜索树的定义：左子树<根节点<右子树
	 * 终止条件：i>=j时，节点数<=1,直接返回true
	 * 递归： 1、 划分左右子树，遍历数组[i,j]，寻找第一个大于根节点的节点m，
	 *       此时划分左右子树[i,m-1],[m,j-1],根节点索引j
	 *       2、判断是否为二叉搜索树
	 *       左子树区间的数应该小于posrorder[j]
	 *       右子树区间的数应该大于postorder[j]，
	 *       当<=postorder[j]时，则跳出，通过p==j判断是否为二叉搜索树
	 *        
	 *@author ZSM
	 * @param postorder
	 * @return
	 */
	public boolean verifyPostorder(int[] postorder) {
		return recur(postorder, 0, postorder.length - 1);
	}

	boolean recur(int[] postorder, int i, int j) {
		if (i >= j)
			return true;
		int p = i;
		while (postorder[p] < postorder[j])
			p++;
		int m = p;
		while (postorder[p] > postorder[j])
			p++;
		return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
	}
	public static void main(String[] args) {
		VerifyPostorder postorder = new VerifyPostorder();
		int[] order= {4, 8, 6, 12, 16, 14, 10};
		boolean b = postorder.verifyPostorder(order);
		System.out.println(b);
		
	}
}
