package tree;

/**
 * 红黑树 步骤： 1、创建红黑树，定义颜色 2、创建RBNode
 * 3、辅助方法定义（parentOf(node),setRed(red),setBlack(black),InOrderPrint()）
 * 4、左旋方法定义leftRotate() 5、右旋方法定义rightRotate() 6、公开插入方法定义insert(K k,V v)
 * 7、内部插入方法定义insert(RBNode node) 8、修正插入导致的红黑树失衡的方法定义InsertFixUp(RBNode node)
 * 9、测试红黑树的正确性
 * 
 * @author ZSM
 *
 * @time 2020年2月11日下午7:38:57
 */
public class RBTree<K extends Comparable<K>, V> {
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private RBNode<K,V> root;

	/**
	 * 返回该节点的父节点
	 * 
	 * @author ZSM
	 * @param node
	 * @return
	 */
	public RBNode<K, V> parentOf(RBNode<K, V> node) {
		if (node == null) {
			return null;
		}
		return node.parent;
	}

	/**
	 * 判断是否为红色节点
	 * 
	 * @author ZSM
	 * @param node
	 * @return
	 */
	private boolean isRed(RBNode node) {
		if (node != null) {
			return node.color == RED;
		}
		return false;
	}

	/**
	 * 是否为黑色节点
	 * 
	 * @author ZSM
	 * @param node
	 * @return
	 */
	private boolean isBlack(RBNode<K,V> node) {
		if (node != null) {
			return node.color == BLACK;
		}
		return false;
	}

	/**
	 * 设置节点为红色
	 * 
	 * @author ZSM
	 * @param node
	 */
	private void setRed(RBNode<K,V> node) {
		if (node != null) {
			node.color = RED;
		}
	}

	/**
	 * 设置节点为黑色
	 * 
	 * @author ZSM
	 * @param node
	 */
	private void setBlack(RBNode<K,V> node) {
		if (node != null) {
			node.color = BLACK;
		}
	}

	/**
	 * 中序打印二叉树
	 * 
	 * @author ZSM
	 */
	public void inOrderPrint() {
		inOrderPrint(this.root);
	}

	private void inOrderPrint(RBNode<K,V> node) {
		if (node != null) {
			inOrderPrint(node.left);
			System.out.println("key:" + node.key + "\t" + "value:" + node.value);
		}
	}

	/**
	 * 左旋 左旋示意，
	 * 左旋x节点
	 *      P               P 
	 *      |               | 
	 *      x               y 
	 *     / \     --->    / \ 
	 *    lx y            x  ry 
	 *      / \          / \ 
	 *     ly ry        lx ly
	 * 
	 * 1、将x的右子节点指向y的左子结点（ly），将x的父节点的左子结点（或者右子节点）更新为y
	 * 2、当x的父节点不为空时，更新y的父节点为x的原父节点，并将x的父节点指定子树（当前x的子树位置）指定为y
	 * 3、将x的父节点更新为y，将y的左子结点更新为x
	 * 
	 * @author ZSM
	 * @param node
	 */
	private void leftRotate(RBNode<K, V> node) {
		if (node != null) {
			RBNode<K, V> y = node.right;
			node.right = y.left;
			if (node.parent != null) {
				if (node == node.parent.left) {
					node.parent.left = y;
				} else {
					node.parent.right = y;
				}
			} else {
				this.root = y;
				this.root.parent = null;
			}
			node.parent = y;
			y.left = node;
		}
	}
	
	/**
	 * 右旋
	 * 右旋x节点
	 *      P               P 
	 *      |               | 
	 *      y               x 
	 *     / \     --->    / \ 
	 *    x  ry           lx  y 
	 *   / \                 / \
	 *  lx ly               ly ry 
	 * 
	 *1、另存y节点，将x的父节点指向y的父节点，更新y的父节点的左子树（或者右子树）为x
	 *2、如果x的右子树不为空，将y的左子树指向为x的右子树，同时更新x的右子树的父节点为y；
	 *3、最后将x的右节点更新为y节点
	 * 
	 * （别人的思路）右旋y节点
	 * 1、将y的左子结点指向x的右子节点，并且更新x的右子节点的父节点为y
	 * 2、当y的父节点不为空时，更新x的父节点为y的父节点，更新y的父节点的指定节点（y当前的位置）为x
	 * 3、更新y的父节点为x，更新x的右子节点为y
	 */
	private void rightRotate(RBNode<K, V> node) {
		if(node!=null) {
			RBNode<K, V> x = node.left;
			node.left = x.left;
			if(x.right!=null) {
			    x.right.parent = node;
			}
			if(node.parent!=null) {
				x.parent = node.parent;
				if(node==node.parent.right) {
					node.parent.right = x;
				}else {
					node.parent.left = x;
				}
			}else {
				this.root = x;
				this.root.parent = null;
			}
			node.parent = x;
			x.right = node;
			
		}
	}
	
	/**
	 * 公开插入方法
	 *@author ZSM
	 * @param node
	 */
	public void insert(K key, V value) {
		RBNode<K,V> node = new RBNode<K,V>();
		node.setKey(key);
		node.setValue(value);
		insert(node);
	}
	
	private void insert(RBNode<K,V> node) {
		RBNode<K, V> parent = null;
		RBNode<K, V> x = this.root;
		while(x!=null) {
			parent = x;
			/*
			 * 
			 * 首先得根据二分搜索树的性质找到这个节点的父节点
			 * 1、差值大于0，往右子树查找
			 * 2、差值等于0，替换
			 * 3、差值小于0，往左子树查找
			 */
			int cmp = node.key.compareTo((K) x.key);
			if(cmp>0) {
				x = x.right;
			}else if(cmp==0) {
				x.setValue(node.getValue());
			}else {
				x = x.left;
			}
		}
		node.parent = parent;
		if(parent!=null) {
			int cmp = parent.key.compareTo(node.key);
			if(cmp>0) {
				parent.right = node;
			}else {
				parent.left = node;
			}
		}else {
			this.root = node;
		}
		
		//调用修复红黑树平衡的方法
		
	}
	/**
	 * 修复红黑树平衡的方法
	 * 
	 * 插入后修复红黑树平衡的方法
	 *       |--- 情景1：红黑树为空树（将根节点染色为黑色）
	 *       |--- 情景2：插入节点的key已经存在（不需要处理）
	 *       |--- 情景3：插入节点的父节点为黑色
	 *       情景4：需要去处理的
	 *       |--- 情景4：插入节点的父节点为红色
	 *            |---情景4.1：叔叔节点存在，并且为红色（父、叔双红LL）将爸爸和叔叔染色为黑色，将爷爷染色为红色，并且以爷爷节点为当前节点，进行下一轮处理
	 *            |---情景4.2：叔叔节点不存在，或者为黑色，父节点为爷爷节点的左子树
	 *                |---情景4.2.1：插入节点为其父节点的左子节点（将爸爸节点染色为黑色，爷爷节点染色为红色，然后以爷爷节点为当前节点进行右旋
	 *                |---情景4.2.2：插入节点为其父节点的右节点（以爸爸节点进行一次左旋，得到LL双红的情景（4.2.1），然后指定爸爸节点为当前节点进行下一轮处理
	 *            |---情景4.3：叔叔节点不存在，或者为黑色，父节点为爷爷节点的右子树
	 *                |---情景4.3.1：插入节点为其父节点的右子节点（RR情况）
	 *                |---情景4.3.2：插入节点为其父节点的左子节点（RL情况）
	 *@author ZSM
	 * @param node
	 */
	private void insertFixup(RBNode node) {
		
	}
	
	static class RBNode<K extends Comparable<K>, V> {
		private RBNode<K, V> parent;
		private RBNode<K, V> left;
		private RBNode<K, V> right;
		private boolean color;
		private K key;
		private V value;

		public RBNode(RBNode<K, V> parent, RBNode<K, V> left, RBNode<K, V> right, boolean color, K key, V value) {
			super();
			this.parent = parent;
			this.left = left;
			this.right = right;
			this.color = color;
			this.key = key;
			this.value = value;
		}

		public RBNode() {

		}

		public RBNode<K, V> getParent() {
			return parent;
		}

		public void setParent(RBNode<K, V> parent) {
			this.parent = parent;
		}

		public RBNode<K, V> getLeft() {
			return left;
		}

		public void setLeft(RBNode<K, V> left) {
			this.left = left;
		}

		public RBNode<K, V> getRight() {
			return right;
		}

		public void setRight(RBNode<K, V> right) {
			this.right = right;
		}

		public boolean isColor() {
			return color;
		}

		public void setColor(boolean color) {
			this.color = color;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

	}

}
