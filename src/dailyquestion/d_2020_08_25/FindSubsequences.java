package dailyquestion.d_2020_08_25;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 递增子序列
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], 
 *       [4, 6, 7, 7], [6, 7], [6, 7, 7],
 *       [7,7], [4,7,7]
 *      ]
 * @author Administrator
 *
 */
public class FindSubsequences {

	private Set<List<Integer>> res = new HashSet<>();
	public List<List<Integer>> findSubsequences(int[] nums){
		if(nums.length==0) {
			return new ArrayList<List<Integer>>();
		}
		List<Integer> list = new ArrayList<>();
		help(list,nums,0);
		return new ArrayList<>(res);
	}
	
	public void help(List<Integer> list,int[] nums,int start) {
		if(list.size()>=2) {
			res.add(new ArrayList<>(list));
		}
		
		for(int i=start;i<nums.length;i++) {
			if(list.size()==0 || list.get(list.size()-1)<=nums[i]) {
				list.add(nums[i]);
				help(list,nums,i+1);
				list.remove(list.size()-1);
			}
		}
	}
}
