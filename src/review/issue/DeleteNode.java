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
class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        //先找到目标值的节点
        //可以根据二叉搜索树的特性（左<中<右） 找目标节点
        //找到之后删除
        //删除需要保持原有的二叉搜索树特性，所以可以找需删节点左节点中的最大值补上，或者找右节点中的最小值补上即可
        //基本思路仍然是前序遍历
        
        return getAndDelNode(root,key);
    }
    
    public TreeNode getAndDelNode(TreeNode root,int key){
        if(root ==null){
            return null;
        }
        int val = root.val;
        if(key>val){
            root.right = getAndDelNode(root.right,key);
        }else if(key<val){
            root.left = getAndDelNode(root.left,key);
        }else{
            if(root.left==null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            //找到右子树的最小节点填补上
            TreeNode minNode = getMin(root.right);
            root.right = getAndDelNode(root.right,minNode.val);
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        }
        return root;
    }
    
    public TreeNode getMin(TreeNode root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    
}
