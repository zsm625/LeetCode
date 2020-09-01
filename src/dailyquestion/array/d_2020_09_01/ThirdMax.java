package dailyquestion.array.d_2020_09_01;

import java.util.Arrays;

/**
 * 第三大的数
 *   Third Maximum Number
 *   Given a non-empty array of integers, 
 *   return the third maximum number in this array. 
 *   If it does not exist, return the maximum number. 
 *   The time complexity must be in O(n).
 * @author zsm
 *
 *     时间：2020年9月1日
 */
public class ThirdMax {

	public int thirdMax(int[] nums) {
		if (nums.length == 0) {
			return -1;
		}
		Integer max1 = null;
		Integer max2 = null;
		Integer max3 = null;
		for (Integer n : nums) {
			if (n.equals(max1) || n.equals(max2) || n.equals(max3))
				continue;
			if (max1 == null || n > max1) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			} else if (max2 == null || n > max2) {
				max3 = max2;
				max2 = n;
			} else if (max3 == null || n > max3) {
				max3 = n;
			}
		}
		return max3 == null ? max1 : max3;

	}
}
