package day_9_15;

import java.util.Stack;

/**
 * 最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，
 * 如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 * 
 * 思路：第一种，暴力遍历，如果是连续的升序，则length-i+1
 * @author ZSM
 *
 * @time 2019年9月15日下午6:21:37
 */
public class FindUnsortedSubarray {
	
	public int findUnsortedSubarray(int[] nums) {
		int size = nums.length;
		int len=size;
		int min = nums[0];
		for(int i=size-2;i>=0;i--) {
			int max = nums[size-1];
			if(nums[i]<=max) {
				len--;
			}else {
				break;
			}
		}
		for(int j=1;j<size;j++) {
			if(nums[j]>=min) {
				len--;
			}else {
				break;
			}
		}
		return len;
		
	}
	
	public int findUnsortedSubarray2(int[] nums) {
		int result = 0;
		int min = 0;
		int max=0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(nums[0]);
		for(int i=1;i<nums.length;i++) {
			if(stack.peek()<=nums[i]) {
				stack.push(nums[i]);
				if(i==nums.length-1) {
					min=0;
				}
			}else {
				min=i-1;
				stack.clear();
				break;
			}
		}
		stack.push(nums[nums.length-1]);
		for(int i=nums.length-2;i>=0;i--) {
			if(stack.peek()>nums[i]) {
				stack.push(nums[i]);
				if(i==0) {
					max=0;
				}
			}else {
				max=i+1;
				stack.clear();
				break;
			}
		}
		if(max==0) {
			result=0;
//			if(max!=0) {
//				result=max;
//			}
		}else if(max-min>0){
			result = max-min+1;
		}
		return result;
	}
	
	public static void main(String[] args) {
//		int[] nums = {2, 6, 4, 8, 10, 9, 15};
		int[] nums = {1,2,3,3,3};
//		int[] nums= {1,2,3,4};
//		int[] nums= {1,3,2,2,2};
//		int[] nums= {2,1};
		System.out.println(new FindUnsortedSubarray().findUnsortedSubarray2(nums));
	}

}
