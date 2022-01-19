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
        //用两个指针分别遍历// 递归
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
    
    // 迭代
     private boolean IterationCheck(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(left);
        deque.offer(right);
        while(!deque.isEmpty()){
             left = deque.poll();
             right = deque.poll();
            if(left==null && right == null){
                continue;
            }
            if(left==null || right==null){
                return false;
            }

            int val1 = left.val;
            int val2= right.val;
            if(val1!=val2){
                return false;
            }
            deque.offer(left.left);
            deque.offer(right.right);
            deque.offer(left.right);
            deque.offer(right.left);
        }
        return true;
    }
}
