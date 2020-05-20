package office66;

/**
 * 二叉搜索树转成双向循环链表
 * 根据题目的要求，头结点为最小的节点
 * 那么根据二叉搜索树的特点，中序遍历的顺序是升序
 * 利用中序遍历先形成一个双向链表，最后形成一个循环，通过保存一个全局变量
 * @author ZSM
 *
 * @time 2020年2月24日下午5:48:58
 */
public class TreeToDoublyList {
	
	private Node head = null,pre = null,tail = null;
	public Node treeToDoublyList(Node root) {
		if(root==null) {
			return root;
		}
		inorder(root);
		//循环连上头尾
		head.left = tail;
		tail.right = head;
		
		return head;
	}

	private void inorder(Node node) {
		//递归终结条件
		if(node==null) {
			return ;
		}
		//访问左子树
		inorder(node.left);
		//将当前节点与前一节点连上
		if(pre==null) {
			head = node;
		}else {
			pre.right = node;
		}
		node.left = pre;
		pre = node;
		tail = node;
		//访问右子树
		inorder(node.right);
		
	}
}
class Node{
	 public int val;
	    public Node left;
	    public Node right;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val,Node _left,Node _right) {
	        val = _val;
	        left = _left;
	        right = _right;
	    }
}
