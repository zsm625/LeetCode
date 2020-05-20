package office66;

import java.util.Arrays;

/**
 * 判断是否为顺子
 * 
 * @author ZSM
 *
 * @time 2020年3月27日上午10:54:17
 */
public class IsStraight {

	/**
	 * 排序法
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public boolean isStraight(int[] nums) {
		if(nums==null || nums.length==0 || nums.length>5) {
			return false;
		}
		Arrays.sort(nums);
		int zero = 0;
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]==0) {
				zero++;
				continue;
			}
			if(nums[i]==nums[i+1]) {
				return false;
			}
			zero-=nums[i+1]-nums[i]-1;
		}
		return zero>=0;
	}
}
