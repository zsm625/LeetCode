package office66;

import java.util.ArrayList;
import java.util.List;

/**
 * 缺失的第一个正整数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * @author ZSM
 *
 * @time 2020年6月27日上午10:13:29
 */
public class FirstMissingPositive {
	/**
	 * 方法一：用list把数组元素保存
	 * 然后从1开始检索，是否含有该元素
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int firstMissingPositive(int[] nums) {
		if(nums==null || nums.length==0){
			return 1;
		}
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<nums.length;i++) {
			list.add(nums[i]);
		}
		int i=1;
		while(list.contains(i)) {
			i++;
		}
		return i;
	}
	
	/**
	 * 原地哈希
	 * 利用原数组编写一个哈希，i对应每个nums[i]-1;
	 * 先对数组进行遍历，将i对应的nums[i]-1放到正确的位置，
	 * 最后遍历修改后的数组，找出i位置没有对应的数，返回缺失的整数
	 * 时间复杂度O(N)
	 * 空间复杂度O(1)
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int firstMissingPositive2(int[] nums) {
		if(nums==null || nums.length==0) {
			return 1;
		}
		for(int i=0;i<nums.length;i++) {
			while(nums[i]>=0 && nums[i]<nums.length && nums[nums[i]-1]!=nums[i]) {
				int temp =nums[nums[i]-1];
				nums[nums[i]-1] = nums[i];
				nums[i] = temp;
			}
		}
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=i+1) {
				return i+1;
			}
		}
		return nums.length+1;
	}
	
	public static void main(String[] args) {
		FirstMissingPositive positive = new FirstMissingPositive();
		int[] nums = {7,8,9,10,11};
		int i = positive.firstMissingPositive(nums);
		System.out.println(i);
	}
}
