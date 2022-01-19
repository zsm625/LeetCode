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
class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        //用两个指针分别遍历
        return check(root,root);
    }

    private boolean check(TreeNode left,TreeNode right){
        if(left==null && right ==null){
            return true;
        }
        if(left == null || right==null){
            return false;
        }
        int leftVal = left.val;
        int rightVal = right.val;
        return (leftVal==rightVal) && check(left.right,right.left) && check(left.left,right.right);
    }
}
