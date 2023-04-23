package zijie_plan;

/**
 * 662. 二叉树最大宽度
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * 树的 最大宽度 是所有层中最大的 宽度 。
 *
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。
 * 将这个二叉树视作与满二叉树结构相同，
 * 两端点间会出现一些延伸到这一层的 null 节点，
 * 这些 null 节点也计入长度。
 */
public class WidthOfBinaryTree{


    public int widthOfBinaryTree(TreeNode root) {
        //广度优先遍历
        Deque<TreeNode> dequeTree = new LinkedList<>();
        Deque<Integer> dequeIndex = new LinkedList<>();
        int width = 0;
        dequeTree.offerLast(root);
        dequeIndex.offerLast(1);
        while(!dequeTree.isEmpty()){
            int treeSize = dequeTree.size();
            int tempWidth = 0;
            int left = -1;
            int right = -1;
            boolean firstFlag = true;
            while(treeSize-->0){
                TreeNode node = dequeTree.pollFirst();
                int index = dequeIndex.pollFirst();
                if(firstFlag){
                    left = index;
                    firstFlag = false;
                }
                right = index;
                //更新当前层的最大宽度
                tempWidth = Math.max(tempWidth,right-left+1);
                if(node.left!=null){
                    dequeTree.offerLast(node.left);
                    dequeIndex.offerLast(index*2);
                }
                if(node.right!=null){
                    dequeTree.offerLast(node.right);
                    dequeIndex.offerLast(index*2+1);
                }

            }
            width = Math.max(width,tempWidth);
        }
        return width;

    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


