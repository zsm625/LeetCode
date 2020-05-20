package simple_100.firstday.tree;

/**
 * 验证二分搜索树
 * @author ZSM
 *
 * @time 2020年1月15日下午12:53:45
 */
public class IsValidBST {
	/**
	 * 递归
	 *@author ZSM
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		if(root ==null) {
			return true;
		}
		
		return isValidBST(root,null,null);
	}
	private boolean isValidBST(TreeNode root,Integer lower,Integer upper) {
		int val = root.val;
		if(lower!=null && val<=lower) {
			return false;
		}
		if(upper!=null && val>=upper) {
			return false;
		}
		if(!isValidBST(root.left,lower,val)){
			return false;
		}
		if(isValidBST(root.right,val,upper)) {
			return false;
		}
		
		return true;
	}
	
}
