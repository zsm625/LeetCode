package office66;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * @author ZSM
 *
 * @time 2020年7月13日上午9:53:32
 */
public class Intersect {

	/**
	 * 哈希表
	 * 空间复杂度好高啊
	 *@author ZSM
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersect(int[] nums1,int[] nums2) {
		if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0) {
			return new int[0];
		}
		Map<Integer,Integer> map = new HashMap<>();
		int len1 = nums1.length;
		int len2 = nums2.length;
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<len1;i++) {
			if(!map.containsKey(nums1[i])) {
				map.put(nums1[i], 1);
			}else {
				Integer temp = map.get(nums1[i]);
				map.put(nums1[i], temp+1);
			}
		}
	   
		for(int j=0;j<len2;j++) {
			if(map.containsKey(nums2[j]) && map.get(nums2[j])!=0) {
				Integer temp = map.get(nums2[j]);
				map.put(nums2[j], temp-1);
				list.add(nums2[j]);
			}
		}
		int[] res = new int[list.size()];
		
		for(int i=0;i<list.size();i++) {
			res[i] = list.get(i);
		}
		
		return res;
	}
	public static void main(String[] args) {
		Intersect intersect = new Intersect();
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		int[] is = intersect.intersect(nums1, nums2);
		for(int i=0;i<is.length;i++) {
			System.out.println(is[i]);
			
		}
	}
}
