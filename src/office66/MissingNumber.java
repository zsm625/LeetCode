package office66;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，
 * 请找出这个数字。
 * @author ZSM
 *
 * @time 2020年7月10日下午12:06:50
 */
public class MissingNumber {

	/**
	 * 看似简单的题，还有很多不同的测试用例
	 * 记住从0开始
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int missingNumber(int[] nums) {
		if(nums==null || nums.length==0 || nums[0]!=0) {
			return 0;
		}
		if(nums.length==1) {
			if(nums[0]%2==0) {
				return nums[0]+1;
			}else {
				return nums[0]-1;
			}
		}
		for(int i=1;i<nums.length;i++) {
			if(nums[i]-nums[i-1]!=1) {
				return nums[i-1]+1;
			}
		}
		return nums[nums.length-1]+1;
	}
}
