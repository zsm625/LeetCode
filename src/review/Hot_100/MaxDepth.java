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
//         traverse(root);
//         return res;
        
        //2、通过分解问题得到答案 得到树的最大深大，那就是左右子树最大高度+1
        if(root == null){
            return 0;
        }
        int ans = 0;

        int leftMax= maxDepth(root.left);
        int rightMaxt = maxDepth(root.right);
        ans = leftMax>rightMaxt?leftMax:rightMaxt;
        return ans+1;
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
