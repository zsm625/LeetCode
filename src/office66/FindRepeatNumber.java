package office66;

import java.util.HashSet;

/**
 * 找到数组中任意的重复数
 * 
 * @author ZSM
 *
 * @time 2020年3月5日下午9:44:19
 */
public class FindRepeatNumber {

	public int findRepeatNumber(int[] nums) {
		if(nums==null || nums.length==0) {
			return -1;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<nums.length;i++) {
			if(!set.add(nums[i])) {
				return nums[i];
			}
		}
		return -1;
	}
}
