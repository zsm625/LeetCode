package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;



/**
 * 二分搜索树
 * 
 * @author ZSM
 *
 * @time 2019年12月6日上午11:01:54
 */
public class SearchTreeDemo {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<Integer>();
		BST<Integer> bst1 = new BST<Integer>();
		int[] nums = { 5, 2, 7, 10, 3, 8 };
		for (int num : nums) {
			bst.addChange(num);
//			bst1.addNR(num);
		}
//		bst.preOrder();
//		System.out.println();
		
//		bst.inOrder();
//		bst1.preOrder();
//		bst.printTree(bst.getRoot(), 1);
//		System.out.println();
//		bst.leverOrder();
		Random random = new Random();
		List<Integer> minList = new ArrayList<>();
		int n = 100;
		for(int i=0;i<n;i++) {
			int nextInt = random.nextInt(1000);
			bst1.addChange(nextInt);
		}
		System.out.println();
		while(!bst1.isEmpty()) {
			minList.add(bst1.removeMin());
		}
		//测试移除最小值是否正确
		for(int i=1;i<minList.size();i++) {
			if(minList.get(i-1)-minList.get(i)>0) {
				throw new IllegalArgumentException("get minmum is wrong");
			}
		}
		System.out.println("minmum right");
		List<Integer> maxList = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			bst1.add(random.nextInt(1000));
		}
		while(!bst1.isEmpty()) {
			maxList.add(bst1.removeMax());
		}
		System.out.println();
		for(int i=1;i<maxList.size();i++) {
//			System.out.print(maxList.get(i-1)+" ");
			if(maxList.get(i-1)-maxList.get(i)<0) {
				throw new IllegalArgumentException("get maxmum is wrong");
			}
		}
		System.out.println();
		System.out.println("right");
		

	}

}

/**
 * 自定义二分搜索树
 * 
 * @author ZSM
 *
 * @time 2019年12月6日上午11:14:03
 */
class BST<E extends Comparable<E>> {
	private Node root;
	private int size;

	public BST() {
		root = null;
		size = 0;
	}

	public Node getRoot() {
		return root;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(E e) {
		if (root == null) {
			root = new Node(e);
		} else {
			add(root, e);
		}

	}

	private void add(Node node, E e) {
		// 不处理重复元素
		if (node.e.equals(e)) {
			return;
		} else if (e.compareTo(node.e) < 0 && node.left == null) {
			node.left = new Node(e);
			size++;
			return;
		} else if (e.compareTo(node.e) > 0 && node.right == null) {
			node.right = new Node(e);
			size++;
			return;
		}

		if (e.compareTo(node.e) < 0) {
			add(node.left, e);
		}
		if (e.compareTo(node.e) > 0) {
			add(node.right, e);
		}

	}

	/**
	 * 修改之后的add方法
	 * 
	 * @author ZSM
	 * @param e
	 */
	public void addChange(E e) {
		root = addChange(root, e);
	}

	/**
	 * 返回向以node元素为根的树插入E数据的节点 简化第一次的递归插入算法
	 * 
	 * @author ZSM
	 * @param node
	 * @param e
	 * @return
	 */
	private Node addChange(Node node, E e) {
		if (node == null) {
			size++;
			return new Node(e);
		}
		if (node.e.compareTo(e) > 0) {
			node.left = addChange(node.left, e);
			
		} else if (node.e.compareTo(e) < 0) {
			node.right = addChange(node.right, e);
		}

		return node;
	}

	
	/**
	 * 前序遍历
	 * 
	 * @author ZSM
	 */
	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.e + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void inOrder() {
		inOrder(root);
	}
	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		preOrder(node.left);
		System.out.print(node.e + " ");
		preOrder(node.right);
	}

	/**
	 * 层次遍历
	 *@author ZSM
	 */
	public void leverOrder() {
		leverOrder(root);
	}
	private void leverOrder(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);
		while(!queue.isEmpty()) {
			Node poll = queue.poll();
			if(poll!=null) {
				System.out.print(poll.e+" ");
				queue.offer(poll.left);
				queue.offer(poll.right);
			}
			
		}
	}
	
	/**
	 * 找到二分搜索树的最小值
	 *@author ZSM
	 * @return
	 */
	public E minmum() {
		if(size ==0) {
			throw new IllegalArgumentException("BST is empty");
		}
		return minmum(root).e;
	}
	
	private Node minmum(Node node) {
		if(node.left == null) {
			return node;
		}
		 
		return minmum(node.left);
	}
	
	/**
	 * 返回二分搜索树的最大值
	 *@author ZSM
	 * @return
	 */
	public E maxmum() {
		if(size ==0) {
			throw new IllegalArgumentException("BST is empty");
		}
		return maxmum(root).e;
		
	}
	private Node maxmum(Node node) {
		if(node.right==null) {
			return node;
		}
		 
		return maxmum(node.right);
	}
	
	/**
	 * 移除最小的值并返回
	 *@author ZSM
	 * @return
	 */
	public E removeMin() {
		E e = minmum();
		root = removeMin(root);
		return e;
	}
	/**
	 * 移除二分搜索数的最小节点，并返回该节点
	 *@author ZSM
	 * @param node
	 * @return
	 */
	private Node removeMin(Node node) {
		//终止递归条件
		if(node.left==null) {
			Node rightNode = node.right;
			node.right = null;
			//一定记住要对size进行维护
			size--;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}
	
	/**
	 * 移除最大节点并返回最大值
	 *@author ZSM
	 * @return
	 */
	public E removeMax() {
		E e = maxmum();
		root = removeMax(root);
		return e;
	}
	/**
	 * 移除最大节点并返回该节点
	 *@author ZSM
	 * @param node
	 * @return
	 */
	private Node removeMax(Node node) {
		if(node.right ==null) {
			Node leftNode = node.left;
			node.left=null;
			size--;
			return leftNode;
		}
		node.right = removeMax(node.right);
		return node;
	}
	
	/**
	 * 从二叉树中删除元素为e的节点
	 *@author ZSM
	 * @param e
	 */
	public void remove(E e) {
		root = remove(root,e);
	}
	
	
	private Node remove(Node node,E e) {
		if(node==null) {
			return null;
		}
		if(e.compareTo(node.e)>0) {
			node.right = remove(node.right,e);
			return node;
		}
		if(e.compareTo(node.e)<0) {
			node.left = remove(node.left,e);
			return node;
		}
		else {//e==node.e
			if(node.left==null) {
				Node rightNode = node.right;
				node.right=null;
				size--;
				return rightNode;
			}
			if(node.right==null) {
				Node leftNode = node.left;
				node.left=null;
				size--;
				return leftNode;
			}
			else {
				//firstone replace by the minmum of right subtree 
				//先找到比当前节点（子树）要大的最小节点
				Node min = minmum(node.right);
				//将子树的最小节点移除
				min.right = removeMin(node.right);
				min.left = node.left;
				node.left=node.right=null;
				return min;
				
			}
		}
	}
	
	/*
	 * 小练习
	 * 1、实现二分搜索树的 floor和ceil方法
	 * floor方法是，找到比当前节点小的最大值
	 */
	
	public E floor(E e) {
		
		
		
		return e;
	}
	/**
	 * 找到比当前节点小的最大节点，并返回
	 *@author ZSM
	 * @param node
	 * @param e
	 * @return
	 */
	private Node floor(Node node,E e) {
		//先找到当前这个值所在的节点
		if(node ==null) {
			return null;
		}
		//如果小就往左走
		if(e.compareTo(node.e)<0) {
			node.left = floor(node.left,e);
		}
		if(e.compareTo(node.e)>0) {
			node.right = floor(node.right,e);
		}
		else {
			//如果e==node.e
			//找比这个值小的最大值
			Node successor = maxmum(node.left);
			return successor;
		}
		
		return node;
		
	}
	
	
	private class Node {
		public E e;
		public Node left;
		public Node right;

		public Node(E e) {
			this.e = e;
			left = null;
			right = null;
		}
	}

}
