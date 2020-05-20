package day_9_19;

/**
 * 获取二叉树的下一个节点； 给定一个二叉树和一个节点，根据中序遍历得出下一个节点 根据中序遍历的特点，左中右，如果该节点是根节点，那么下一个节点就是右节点，
 * 如果是左节点，下一个节点就是根节点， 如果是右节点，
 * 
 * @author ZSM
 *
 * @time 2019年9月28日上午10:47:41
 */
public class BTreeGetNext {

	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode.right != null) {
			pNode = pNode.right;
			while (pNode.left != null) {
				pNode = pNode.left;
			}
			return pNode;
		}else {
			 while(pNode.next!=null) {
				 TreeLinkNode parent = pNode.next;
				 if(parent.left==pNode) {
					 return parent;
				 }else {
					 pNode= pNode.next;
				 }
				 
			 }
		}
		
		return null;
	}

}

class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null;

	TreeLinkNode(int val) {
		this.val = val;
	}
}
