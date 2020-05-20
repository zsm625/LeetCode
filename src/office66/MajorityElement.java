package office66;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 找到数组中元素出现过n/2次的元素
 * 
 * @author ZSM
 *
 * @time 2020年3月13日下午6:08:12
 */

public class MajorityElement {

	/**
	 * 执行用时 :27 ms, 在所有 Java 提交中击败了14.03%的用户
	 * 内存消耗 :46.9 MB, 在所有 Java 提交中击败了5.07%的用户
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		if(nums==null || nums.length==0) {
			return -1;
		}
		int n = nums.length/2;
		int max = 0;
		int num = 0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i])+1);
			}else {
				map.put(nums[i], 1);
			}
			if(map.get(nums[i])>max) {
				max = map.get(nums[i]);
				num = nums[i];
			}
		}
		if(max>=n) {
			return num;
		}else {
			return -1;
		}
		
	}
	
	public static void main(String[] args) {
		MajorityElement element = new MajorityElement();
		int[] nums= {2,2,1,1,1,2,2};
		int i = element.majorityElement(nums);
		System.out.println(i);
	}
}
