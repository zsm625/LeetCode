package simple_100.firstday.tree;

/**
 * 根据中序序列和前序序列创建二叉树
 * @author ZSM
 *
 * @time 2020年1月19日下午2:52:16
 */
public class BuildTree {
	public TreeNode buildTree(int[] preorder,int[] inorder) {
		return buildTree(preorder,0,preorder.length,inorder,0,inorder.length);
	}
	
	private TreeNode buildTree(int[] preorder,int pre_start,int pre_end,int[] inorder,int in_start,int in_end) {
		if(pre_start==pre_end || in_start==in_end) {
			return null;
		}
		int root_val = preorder[pre_start];
		TreeNode root = new TreeNode(root_val);
		int root_index = 0;
		//从中序序列中获取根节点的索引
		for(int i=in_start;i<in_end;i++) {
			if(root_val==inorder[i]) {
				root_index=i;
				break;
			}
		}
		int leftNum = root_index-in_start;
		root.left = buildTree(preorder,pre_start+1,pre_start+leftNum+1,inorder,in_start,root_index);
		root.right = buildTree(preorder,pre_start+leftNum+1,pre_end,inorder,root_index+1,in_end);
		return root;
	}
	
}
