package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 思路：将target值与数组的每一个值相减，然后将得到的值与数组剩下的值进行比较
 * @author ZSM
 *
 * @time 2019年10月29日上午11:01:50
 */
public class FindTargetSum {
	/**
	 * 方法1：时间复杂度：n(n-1)/2，加上break后循环次数减少
	 *@author ZSM
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] findTarget(int[] nums, int target) {
//		int k=0;测试循环次数
		int[] result = new int[2];
		for(int i=0;i<nums.length;i++) {
			int temp = target-nums[i];//3
			for(int j=i+1;j<nums.length;j++) {
//				k++;
				if(temp==nums[j]) {
					result[0]=i;
					result[1]=j;
					break;
				}
			}
		}
//		System.out.println(k);
		return result;		
	}
	
	/**
	 * 通过使用map，将时间复杂度缩小为O（n）
	 * 但找出来的值是倒着的顺序
	 *@author ZSM
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] findTarget2(int[] nums,int target) {
		int[] result = new int[2];
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			map.put(nums[i], i);
			int temp = target-nums[i];
			if(map.get(temp)!=null) {
				result[0]=i;
				result[1]=map.get(temp);
				break;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		FindTargetSum sum = new FindTargetSum();
		int[] nums = {2, 7, 11, 15};
		int[] target = sum.findTarget2(nums, 18);
		System.out.println(Arrays.toString(target));
	}


}
