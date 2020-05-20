package office66;

import java.util.Arrays;

public class MinIncrementForUnique {

	/**
	 * 用贪心算法
	 * 主要消耗在sort上
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int minIncrementForUnique(int[] nums) {
		if(nums==null || nums.length==0) {
			return 0;
		}
		int res = 0;
		Arrays.sort(nums);
		for(int i=1;i<nums.length;i++) {
			if(nums[i-1]>=nums[i]) {
				int temp=nums[i];
				nums[i] += nums[i-1]-temp+1;
				res+=nums[i]-temp;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		MinIncrementForUnique unique = new MinIncrementForUnique();
		int[] nums= {1,2,2};
		int i = unique.minIncrementForUnique(nums);
		System.out.println(i);
	}
}
