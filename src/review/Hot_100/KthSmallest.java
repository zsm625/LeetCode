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
class Solution {
    int res = 0;
    int lever = 0;
    public int kthSmallest(TreeNode root, int k) {
        //二叉搜索树中序遍历是从小到大的顺序排序 
        inorder(root,k);
        return res;
    }

    public void inorder(TreeNode root,int target){
        if(root == null){
            return ;
        }
        inorder(root.left,target);
        lever++;
        if(lever == target){
           res = root.val;
        }
        inorder(root.right,target);
    }
}
