package simple_100.firstday.array;

/**
 * 最大子序和
 * @author ZSM
 *
 * @time 2020年2月5日下午6:05:01
 */
public class MaxSubArray {

	public int maxSubArray(int[] nums) {
		
		return 0;
	}
	
	public int crossSum(int[] nums,int left,int right,int p) {
		if(left==right) return nums[left];
		
		int leftSubsum = Integer.MIN_VALUE;
		int currSum = 0;
		for(int i=p;i>left-1;--i) {
			currSum+=nums[i];
			leftSubsum = Math.max(leftSubsum, currSum);
		}
		int rightSubsum = Integer.MIN_VALUE;
		for(int i=p+1;i<right+1;i++) {
			currSum+=nums[i];
			rightSubsum = Math.max(rightSubsum, currSum);
		}
		return leftSubsum + rightSubsum;
	}
	
	
	/**
	 * 返回和为最大的子数组
	 * 如[-1,2,-3,12,3,-8],得到的结果为[12,3]
	 * 可以采用快慢指针的方法
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int[] maxSubArray2(int[] nums) {
		if(nums.length==0) {
			return null;
		}
		int fast = 1;
		int slow = 0;
		int sum = 0;
		int max = 0;
		for(int i=1;i<nums.length;i++) {
			sum+=nums[i];
			if(sum>max) {
				max = sum;
				fast=i;
			}
			if(sum<nums[i]) {
				sum = nums[i];
				slow = i;
			}
			
		}
		return null;
	}
}
