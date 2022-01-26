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
class FindDuplicateSubtrees {
    Map<String,Integer> set = new HashMap<>();
    List<TreeNode> sameNode = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return sameNode;
    }
    
    public String traverse(TreeNode root){
        if(root==null){
            return "#";
        }
        
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left+","+right+","+root.val;
        if(set.containsKey(subTree)){
            Integer count = set.get(subTree);
            if(count ==1){
                sameNode.add(root);
            }
            set.put(subTree,count+1);
        }else{
            set.put(subTree,1);
        }
        return subTree;
    }
}
