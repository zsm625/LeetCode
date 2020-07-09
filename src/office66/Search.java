package office66;

import java.util.HashMap;
import java.util.Map;

/**
 * 在排序数组中查找数字I
 * 统计一个数字在排序数组中出现的次数。
 * @author ZSM
 *
 * @time 2020年7月9日上午11:54:14
 */
public class Search {
	/**
	 * 方法一。用map将num出现的次数存储
	 *@author ZSM
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums,int target) {
		if(null==nums || nums.length==0) {
			return 0;
		}
		Map<Integer,Integer> map = new HashMap<>();
		map.put(nums[0], 1);
		for(int i=1;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				Integer temp = map.get(nums[i]);
				map.put(nums[i], temp+1);
			}else {
				map.put(nums[i], 1);
			}
		}
		
		if(map.containsKey(target)) {
			return map.get(target);
		}else {
			return 0;
		}
	}
	
	/**
	 * 使用二分法
	 * 思路：两边遍历，先找到左边第一个target，再找到右边最后一个出现的target
	 *@author ZSM
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search2(int[] nums,int target) {
		if(null==nums || nums.length==0) {
			return 0;
		}
		int left = -1;
		int right=-1;
		for(int i=0;i<nums.length;i++) {
			if(target==nums[i]) {
				left=i;
				break;
			}
		}
		for(int j=nums.length-1;j>=0;j--) {
			if(target==nums[j]) {
				right=j;
				break;
			}
		}
		if(left<0&& right<0) {
			return 0;
		}
		return right-left+1;
	}

	public static void main(String[] args) {
		Search search = new Search();
		int[] nums= {5,6,7,9,9,9};
		int target = 8;
		int i = search.search2(nums, target);
		System.out.println(i);
	}
}
