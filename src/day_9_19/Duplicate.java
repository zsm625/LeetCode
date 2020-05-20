package day_9_19;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，
 * 也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * @author ZSM
 *
 * @time 2019年9月19日上午9:37:35
 */
public class Duplicate {

	
	/**
	 * 思路：将数组中的值按照下标的位置排好，如0就放到第一位
	 *@author ZSM
	 * @param nums 原数组
	 * @param length  原数组长度
	 * @param duplication 放置重复数字的数组
	 * @return
	 */
	public boolean duplicate(int[] nums,int length,int[] duplication) {
		if(nums==null && length<=0) {
			return false;
		}
		for(int i=0;i<length;i++) {
			while(nums[i]!=i) {
				if(nums[i]==nums[nums[i]]) {
					duplication[0]=nums[i];
					return true;
				}
				swap(nums,i,nums[i]);
			}
			
		}
		
		return false;
	}
	
	private void swap(int[] nums ,int i,int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j]=temp;
		
	}

}
