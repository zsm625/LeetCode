package office66;

/**
 * 是否为树的子结构 输入两棵二叉树A和B，判断B是不是A的子结构。
 * (约定空树不是任意一个树的子结构) B是A的子结构， 即
 * A中有出现和B相同的结构和节点值。
 * 
 * @author ZSM
 *
 * @time 2020年3月28日上午11:29:05
 */
public class IsSubStructure {
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		return (A!=null&&B!=null)&&(findBInA(A,B) || isSubStructure(A.right,B) || isSubStructure(A.left,B)); 
	}
	public boolean findBInA(TreeNode A,TreeNode B) {
		if(B==null) {
			return false;
		}
		if(A==null || A.val!=B.val) {
			return false;
		}
		
		return findBInA(A.left,B.left)&&findBInA(A.right,B.right);
	}
	
}
