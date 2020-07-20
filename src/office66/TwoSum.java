package office66;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
	
	/**
	 * 两数之和II
	 * 给定一个已按照升序排列的有序数组，
	 * 找到两个数使得它们相加之和等于目标数。
	 * 函数应该返回这两个下标值 index1 和 index2，
	 * 其中 index1 必须小于 index2
	 * 
	 * 第一种方法：使用hash表来解决，但是超出时间限制
	 *@author ZSM
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum3(int[] nums ,int target) {
		if(nums==null || nums.length==0) {
			return nums;
		}
		List<int[]> asList = Arrays.asList(nums);
		List<Integer> list = new ArrayList<>(nums.length);
		for(int i=0;i<nums.length;i++) {
			list.add(nums[i]);
		}
		int[] res = new int[2];
		for(int j=0;j<nums.length;j++) {
			int temp = target-nums[j];
			if(list.contains(temp)) {
				if(j!=list.lastIndexOf(temp)) {
					res[0] = j+1;
					res[1] =1+(list.lastIndexOf(temp));
					break;
				}
			}
		}
		return res;
	}
	
	/**
	 * 双指针法
	 *@author ZSM
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum4(int[] nums,int target) {
		if(nums==null || nums.length==0) {
			return new int[]{-1,-1};
		}
		int[] res = new int[2];
		int left = 0,right = nums.length-1;
		while(left<=right) {
			int temp = nums[left]+nums[right];
			if(temp==target) {
				res[0] = left+1;
				res[1] = right+1;
				break;
			}
			if(temp<target) {
				left++;
			}
			if(temp>target) {
				right--;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		TwoSum sum = new TwoSum();
		int[] nums = {0,0,11,15};
		int[] is = sum.twoSum4(nums, 0);
		for(int i=0;i<2;i++) {
			System.out.print(is[i]+"\t");
		}
	}
}
