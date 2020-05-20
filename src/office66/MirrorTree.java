package office66;

/**
 * 二叉树的镜像
 * @author ZSM
 *
 * @time 2020年3月17日下午4:32:57
 */
public class MirrorTree {

	public TreeNode mirrorTree(TreeNode root) {
		if(root==null) {
			return null;
		}
		TreeNode rightTemp = root.right;
		root.right = root.left;
		root.left = rightTemp;
		mirrorTree(root.left);
		mirrorTree(root.right);
		return root;
		
		
	}
}
