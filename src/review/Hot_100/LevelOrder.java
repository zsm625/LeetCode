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
class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //层级遍历 ：while / for 分管从上到下，从左到右
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if(root == null){
            return res;
        }
        
        deque.offer(root);
        while(!deque.isEmpty()){
            int s=deque.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode temp = deque.poll();
                list.add(temp.val);
                if(temp.left!=null){
                    deque.offer(temp.left);
                }
                if(temp.right!=null){
                    deque.offer(temp.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
