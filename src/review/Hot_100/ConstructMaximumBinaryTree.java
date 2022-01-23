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
class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
       return  build(nums,0,nums.length-1);
    }


    public TreeNode build(int[] nums,int lo,int ro){
        if(lo>ro){
            return null;
        }

        int index = -1;
        int maxVal = Integer.MIN_VALUE;
        for(int i=lo;i<=ro;i++){
            if(nums[i]>maxVal){
                maxVal = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode();
        root.val = maxVal;
        root.left = build(nums,lo,index-1);
        root.right = build(nums,index+1,ro);

        return root;

    }
}
