package simple_100.firstday.tree;

/**
 * 将树变成链表
 * @author ZSM
 *
 * @time 2020年1月23日上午11:53:32
 */
public class Flatten {

	/**
	 * 迭代
	 * 思路：将左子树插入到右子树，用变量保存右子树，并将右子树插入到左子树右边的最后，重复之前的动作
	 *@author ZSM
	 * @param root
	 */
	public void flatten(TreeNode root) {
		while(root!=null) {
			if(root.left==null) {
				root = root.right;
			}else {
				TreeNode pre = root.left;
				//找左子树的最右节点
				while(pre.right!=null) {
					pre=pre.right;
				}
				//将右节点放到左子树的最右节点上
				pre.right=root.right;
				root.right = root.left;
				root.left=null;
				root=root.right;
			}
		}
		
	}
	
	/**
	 * 递归来浪啊
	 * 后序的变化形式（右-左-中）
	 * 自底向上遍历
	 * ？？？
	 *@author ZSM
	 * @param root
	 */
	private TreeNode pre =null;
	public void flatten1(TreeNode root) {
		if(root==null) {
			return;
		}
		flatten1(root.right);
		flatten1(root.left);
		root.right = pre;
	    root.left = null;
	    pre = root;
		
	}
	
	public static void main(String[] args) {
		Flatten flatten = new Flatten();
		SerializeAndDeserializeTree serialize = new SerializeAndDeserializeTree();
		String data = "1,2,3,null,null,4,null,null,5,null,6";
		TreeNode node = serialize.deserialize(data);
		flatten.flatten1(node);
		String string = serialize.serialize(node);
		System.out.println(string);
		
	}
	
}
