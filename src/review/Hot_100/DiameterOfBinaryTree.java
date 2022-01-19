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
    public int diameterOfBinaryTree(TreeNode root) {
        //这个就是左右子树 深度之和 或者根数的最大深度
        maxDepth(root);
        return res;
    }

    private int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int ans = 0;
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        res = leftMax+rightMax > res?leftMax+rightMax:res;
        ans = 1+(leftMax>rightMax?leftMax:rightMax);
        return ans;
    }
}
