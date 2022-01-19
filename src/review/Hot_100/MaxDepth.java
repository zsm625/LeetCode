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
class MaxDepth {
    int depth = 0;
    int res = 0;
    public int maxDepth(TreeNode root) {
        //1、解题思路：可以通过遍历一棵树得到答案
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root){
        if(root ==null){
            res = depth>res?depth:res;
            return;
        }

    depth++;
    traverse(root.left);
    traverse(root.right);
    depth--;
    }
}
