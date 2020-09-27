package dailyquestion.d_2020_09_28

import dailyquest.TreeNode

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = root;
        if(root == null){
            return null;
        }
        while(true){
            if(p.val>res.val && q.val>res.val){
                res = res.right;
            }else if(p.val<res.val && q.val < res.val){
                res = res.left;
            }else{
                break;
            }

        }
        return res;


    }
}
