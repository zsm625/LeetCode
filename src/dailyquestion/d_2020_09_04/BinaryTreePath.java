package dailyquestion.d_2020_09_04;

import java.util.ArrayList;
import java.util.List;

import dailyquestion.TreeNode;

/**
 * 二叉树的路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 输入:
          1
        /   \
       2     3
        \
         5
         结果：["1->2->5",1->3"]
 * @author zsm
 *
 *     时间：2020年9月4日
 */
public class BinaryTreePath {
	
	/**
	 * 寻常遍历
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePath(TreeNode root){
		List<String> res = new ArrayList<>();
		if(root==null) {
			return res;
		}
		 help(root,"",res);
		 return res;
	}
	
	public void help(TreeNode root,String str,List<String> res){
		if(root!=null) {
			StringBuilder sb = new StringBuilder(str);
			sb.append(String.valueOf(root.val));
			if(root.left==null && root.right==null) {
				res.add(sb.toString());
			}else {
				sb.append("->");
				help(root.left,sb.toString(),res);
				help(root.right,sb.toString(),res);
			}
		}
	}

	public static void main(String[] args) {
		BinaryTreePath path = new BinaryTreePath();
		TreeNode tree = new TreeNode(1);
		TreeNode tree2 = new TreeNode(2);
		TreeNode tree3 = new TreeNode(5);
		TreeNode tree4 = new TreeNode(3);
		tree.left = tree2;
		tree.right = tree4;
		tree2.right = tree3;
		List<String> list = path.binaryTreePath(tree);
		for (String string : list) {
			System.out.println(string);
		}
	}
}
