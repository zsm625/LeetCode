package dailyquestion.array.d_2020_09_01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  Find All Numbers Disappeared in an Array
 *  Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 *   some elements appear twice and others appear once.
 *  Find all the elements of [1, n] inclusive 
 *  that do not appear in this array.
 *  Could you do it without extra space and in O(n) runtime? 
 *  You may assume the returned list does not count as extra space.
 * @author zsm
 *
 *     时间：2020年9月1日
 */
public class FindDisappearedNumbers {

	public List<Integer> findDisappearedNumbers(int[] nums){
		if(nums.length==0) {
			return new ArrayList<>();
		}
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<nums.length;i++) {
			set.add(nums[i]);
		}
		List<Integer> res = new ArrayList<>();
		for(int i=0;i<nums.length;i++) {
			if(!set.contains(i+1)) {
				res.add(i+1);
			}
		}
		return res;
		
		
	}
	
}
