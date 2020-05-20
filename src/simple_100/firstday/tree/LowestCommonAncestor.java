package simple_100.firstday.tree;

/**
 * 找最近公共祖先
 * @author ZSM
 *
 * @time 2020年1月21日上午10:26:17
 */
public class LowestCommonAncestor {

	/**
	 * 在题解中看到的一个特别巧妙的解法
	 *@author ZSM
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
		if(root==null || root.val==p.val || root.val==q.val) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left,p,q);
		TreeNode right = lowestCommonAncestor(root.right,p,q);
		return left==null? right:(right==null ? left : root);
	}
	
	/**
	 * 查找二叉搜索树的最近公共祖先
	 * 因为二叉搜索数的特点：根节点总是大于左节点，根节点总是小于右节点
	 * 如果当前节点比给定的两个节点大就往左子树遍历
	 * 如果当前节点比给定的两个节点小就往右子树遍历
	 * 
	 *@author ZSM
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestorBST(TreeNode root,TreeNode p,TreeNode q) {
		if(root==null || root.val==p.val || root.val==q.val) {
			return root;
		}
		if(root.val>p.val && root.val>q.val) {
			return lowestCommonAncestor(root.left,p,q); 
		}
		if(root.val <p.val && root.val<q.val) {
			return lowestCommonAncestor(root.right,p,q);
		}
		return root;
		
	}
	
	public static void main(String[] args) {
		LowestCommonAncestor ancestor = new LowestCommonAncestor();
		SerializeAndDeserializeTree serialize = new SerializeAndDeserializeTree();
		String data = "3,5,6,null,null,2,7,null,null,4,null,null,1,0,null,null,8,null,null";
		TreeNode node = serialize.deserialize(data);
		String string = serialize.serialize(node);
		System.out.println(string);
		TreeNode commonAncestor = ancestor.lowestCommonAncestor(node, new TreeNode(2), new TreeNode(7));
		System.out.println(commonAncestor.val);
		
	}
}
