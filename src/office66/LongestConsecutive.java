package office66;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。要求算法的时间复杂度为 O(n)。
 * @author ZSM
 *
 * @time 2020年6月6日上午11:10:20
 */
public class LongestConsecutive {
	
	/**
	 * 哈希集，先去重
	 * 时间复杂度为O(N)
	 * 空间复杂度为O(N)
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int longestConsecutive(int[] nums) {
		if(nums==null || nums.length==0) {
			return 0;
		}
		Set<Integer> set_nums = new HashSet<>();
		//去重
		for (int num : nums) {
			set_nums.add(num);
		}
		int longestStreak = 0;
		for(Integer set_num:set_nums) {
			if(!set_nums.contains(set_num-1)) {
				int current_num = set_num;
				int current_streak = 1;
				while(set_nums.contains(current_num+1)) {
					current_num+=1;
					current_streak+=1;
				}
				longestStreak = Math.max(longestStreak,current_streak);
				
			}
		}
		return longestStreak;
	}

	public static void main(String[] args) {
		LongestConsecutive consecutive = new LongestConsecutive();
		int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
		int i = consecutive.longestConsecutive(nums);
		System.out.println(i);
	}
}
