package dailyquestion.office.d_2020_08_02;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @author ZSM
 *
 * @time 2020年8月2日上午11:06:44
 */
public class MajorityElement {
	/**
	 * 首先想到的永远是hash表啊
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		if(nums.length==0) {
			return -1;
		}
		int len = nums.length/2;
		int res = -1;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			}else{
				Integer temp = map.get(nums[i]);
				map.put(nums[i], temp+1);
			}
			if(map.get(nums[i])>=len) {
				res = nums[i];
			}
		}
		return res;
	}
	
	/**
	 * 摩尔票法
	 * 时间复杂度O(N)
	 * 空间复杂度O(1)
	 * 
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int majorityElement2(int[] nums) {
		if(nums.length==0) {
			return -1;
		}
		int vote=0,x = -1;
		for (int num : nums) {
			if(vote==0) {
				x=num;
			}
			vote+=num==x?1:-1;
		}
		return x;
	}
	
	public static void main(String[] args) {
		MajorityElement element = new MajorityElement();
		int[] nums = {3,2,3};
		int i = element.majorityElement2(nums);
		System.out.println(i);
	}
}
