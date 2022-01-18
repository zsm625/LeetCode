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
class IsValidBST{
    public boolean isValidBST(TreeNode root) {
        //遍历获取所有节点值，判断排序
        List<Integer> vals = new ArrayList<>();
        midOrder(root,vals);
        if(vals.size()<=1){
            return true;
        }
        for(int i=1;i<vals.size();i++){
            if(vals.get(i)<=vals.get(i-1)){
                return false;
            }
        }
        return true;
    }

    private void midOrder(TreeNode root,List<Integer> vals){
        if(root==null){
            return;
        }

        midOrder(root.left,vals);
        vals.add(root.val);
        midOrder(root.right,vals);
    }
}
