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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

/**
从前序遍历得到 根节点
从中序遍历得到 左右子树
 */
    public TreeNode build(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        if(preStart>preEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        int index = 0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==rootVal){
                index = i;
                break;
            }
        }
        int length = index-inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder,preStart+1,preStart+length,
                           inorder,inStart,index-1);
        root.right = build(preorder,preStart+length+1,preEnd,
                           inorder,index+1,inEnd);
        return root;
    }
    
    /**
    通过中序遍历和后序遍历构建一颗二叉树
后序遍历：最后一个节点是根节点
 */
    public TreeNode build(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd){
        if(inStart>inEnd){
            return null;
        }
        int rootVal = postorder[postEnd];
        int index = 0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i] == rootVal){
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        int leftSize = index-inStart;
        root.left = build(inorder,inStart,index-1,postorder,postStart,postStart+leftSize-1);
        root.right = build(inorder,index+1,inEnd,postorder,postStart+leftSize,postEnd-1);
        return root;
    }
}
