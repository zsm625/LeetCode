package simple_100.firstday.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 序列化与反序列化二叉树
 * 
 * @author ZSM
 *
 * @time 2020年1月19日下午8:39:52
 */
public class SerializeAndDeserializeTree {

	/**
	 * 给定一颗树，将其输出为字符串
	 * 
	 * @author ZSM
	 * @param root
	 * @return
	 */
	public String serialize(TreeNode root) {
		StringBuffer str = new StringBuffer();
		serialize(root, str);
		String result = str.toString();
		return result;
	}

	private TreeNode serialize(TreeNode root, StringBuffer str) {
		if (root == null) {
			str.append("null,");
			return null;
		}
		str.append(root.val);
		str.append(",");
		serialize(root.left, str);
		serialize(root.right, str);
		return root;
	}
	

	/**
	 * 给定字符串，将其还原为一棵树
	 * 
	 * @author ZSM
	 * @param data
	 * @return
	 */

	public TreeNode deserialize(String data) {
		String[] strings = data.split(",");
		List<String> rootVal = new LinkedList<>(Arrays.asList(strings));
		return deserialize(rootVal);
	}

	private TreeNode deserialize(List<String> list) {
		if(list==null || list.size()==0) {
			return null;
		}
		if (list.get(0).equals("null")) {
			list.remove(0);
			return null;
		}
		TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
		list.remove(0);
		node.left = deserialize(list);
		node.right = deserialize(list);
		return node;
	}

	public static void main(String[] args) {
		SerializeAndDeserializeTree deserializeTree = new SerializeAndDeserializeTree();
		String data = "3,5,1";
		TreeNode node = deserializeTree.deserialize(data);
		System.out.println(node.val);
	}
}
