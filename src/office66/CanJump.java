package office66;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * @author ZSM
 * 
 * @time 2020年4月17日下午4:55:24
 */
public class CanJump {
	public boolean canJump(int[] nums) {
		if(nums==null || nums.length==0) {
			return false;
		}
		int n = nums.length;
		int rightmost = 0;
		for(int i=0;i<n;i++) {
//			if(i<=rightmost) {
//				rightmost = Math.max(i+nums[i], rightmost);
//			}
//			if(rightmost>=n-1) {
//				return true;
//			}
			if(i>rightmost) {
				return false;
			}
			rightmost = Math.max(i+nums[i], rightmost);
		}
		return true;
	}

}
