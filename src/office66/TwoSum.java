package office66;

import java.util.HashMap;
import java.util.Map;

/**
 * 两个数的和
 * @author ZSM
 *
 * @time 2020年3月21日下午12:08:50
 */
public class TwoSum {

	/**
	 * 第一种，暴力
	 * 但是超出时间了
	 *@author ZSM
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums,int target) {
		int[] res = new int[2];
		for(int i=0;i<nums.length;i++) {
			int num = target-nums[i];
			for(int j=i+1;j<nums.length;j++) {
				if(nums[j]>target) {
					continue;
				}
				if(num==nums[j]) {
					res[0]=nums[j];
					res[1] = nums[i];
				}
			}
		}
		return res;
	}
	
	public int[] twoSum2(int[] nums,int target) {
		int[] res = new int[2];
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			int num = target-nums[i];
			if(map.containsKey(num)) {
				res[0] = num;
				res[1] = nums[i];
				return res;
			}
			map.put(nums[i], num);
		}
		
		return res;
		
	}
	public static void main(String[] args) {
		TwoSum sum = new TwoSum();
		int[] nums = {2,7,11,15};
		int[] is = sum.twoSum2(nums, 9);
		for(int i=0;i<2;i++) {
			System.out.print(is[i]+"\t");
		}
	}
}
