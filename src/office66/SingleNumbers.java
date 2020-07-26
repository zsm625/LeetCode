package office66;

import java.util.HashMap;
import java.util.Map;

/**
 * 找到数组中只出现过一次的序列
 * @author ZSM
 *
 * @time 2020年4月9日上午11:56:55
 */
public class SingleNumbers {

	/**
	 * 利用异或运算的规律来交换
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int[] singleNumbers(int[] nums) {
		if(nums==null || nums.length==0) {
			return new int[0];
		}
		
		int x = 0;
		for(int i=0;i<nums.length;i++) {
			x^=nums[i];
		}
		//得到最低位1
		int flag = x&(-x);
		int res = 0;
		for(int num:nums) {
			if((flag&num) !=0 ) {
				res^=num;
			}
		}
		return new int[] {res,res^x};
	}
	
	/**
	 * 数组中出现数字的次数II
	 * 在一个数组 nums 中除一个数字只出现一次之外，
	 * 其他数字都出现了三次。请找出那个只出现一次的数字。
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int singleNumbers2(int[] nums) {
		if(nums==null || nums.length==0) {
			return -1;
		}
		//最先想到的方式是hash表来做
		int res = -1;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			}else {
				Integer temp = map.get(nums[i]);
				map.put(nums[i], temp+1);
			}
			
		}
		
		for (int i : nums) {
			if(map.get(i)==1) {
				res = i;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		SingleNumbers numbers = new SingleNumbers();
		int[] nums= {9,1,7,9,7,9,7};
		int i = numbers.singleNumbers2(nums);
		System.out.println(i);
	}
}
