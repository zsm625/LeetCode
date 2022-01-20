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
    public List<Integer> rightSideView(TreeNode root) {
        //层级遍历
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        deque.offer(root);
        while(!deque.isEmpty()){
            int s =deque.size();
            for(int i=0;i<s;i++){
                TreeNode temp = deque.poll();
                if(i==0){
                    res.add(temp.val);
                }
                if(temp.right!=null){
                    deque.offer(temp.right);
                }
                if(temp.left!=null){
                    deque.offer(temp.left);
                }
            }
        }
        return res;
    }
}
