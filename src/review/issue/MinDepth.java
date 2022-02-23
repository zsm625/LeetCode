/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class MinDepth {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        // BFS 向外扩散遍历
        // 首先需要一个队列将节点装起来
         //二叉树的特性是父节点指向子节点，不会走重了，所以不需要额外的空间保存走过的路径
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while(!queue.isEmpty()){
            //将当前队列中的节点向四周扩散
            int len = queue.size();
            for(int i=0;i<len;i++){
                //这是同一层的
                TreeNode node = queue.poll();
                //判断是否是终点
                if(node.left==null && node.right==null){
                    return depth;
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            //所以在这里加一
            depth++;
        }
       return depth;
        

    }
}
