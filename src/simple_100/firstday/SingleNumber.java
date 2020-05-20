package simple_100.firstday;

import java.util.Stack;

/**
 * 给定一组数组，找到只出现一次的数字，其他数字均出现多次
 * @author ZSM
 *
 * @time 2020年1月9日下午1:54:26
 */
public class SingleNumber {

	/**
	 * 时间复杂度为O(n)
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
		Stack<Integer> s=new Stack<>();
		s.add(nums[0]);
		for(int i=1;i<nums.length;i++) {
			if(s.contains(nums[i])) {
				s.remove(new Integer(nums[i]));
				continue;
			}
			s.add(nums[i]);
		}
		if((!s.isEmpty()) &&s.size()==1) {
			return s.peek();
		}
		return -1;
	}
	
	/**
	 * 看到一个使用异或的解决方式
	 * 牛逼了
	 * 小本本记录下来
	 *@author ZSM
	 * @param args
	 */
	public int singleNumber2(int[] nums) {
		int result = nums[0];
		for(int i=1;i<nums.length;i++) {
			result = result^ nums[i];
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		SingleNumber single = new SingleNumber();
		int[] nums= {4,2,2,1,4};
		int i = single.singleNumber2(nums);
		System.out.println(i);
	}
}
