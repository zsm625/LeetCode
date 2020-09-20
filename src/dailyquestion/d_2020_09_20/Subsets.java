package dailyquestion.d_2020_09_20;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * @author zsm
 *
 *     时间：2020年9月20日
 */
public class Subsets {

	public List<List<Integer>> sybSets(int[] nums){
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		if(len==0) {
			return res;
		}
		
		dfs(nums,len,0,res,list);
		return res;
	}
	
	public void dfs(int[] nums,int len,int depth,List<List<Integer>> res,List<Integer> list) {
		if(depth==len) {
			res.add(new ArrayList<>(list));
			return;
		}
		list.add(nums[depth]);
		dfs(nums,len,depth+1,res,list);
		list.remove(list.size()-1);
		dfs(nums,len,depth+1,res,list);
		
	}
}
