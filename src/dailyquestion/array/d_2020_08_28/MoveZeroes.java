package dailyquestion.array.d_2020_08_28;

/**
 * MoveZeroes
 *  Given an array nums, 
 *  write a function to move all 0's to the end of it 
 *  while maintaining the relative order of the non-zero elements.
 * @author zsm
 *
 *     时间：2020年8月28日
 */
public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		if(nums.length==0) {
			return;
		}
		int begin = 0;
		for(int num:nums) {
			if(num!=0) {
				nums[begin++]=num;
			}
		}
		
		while(begin<nums.length) {
			nums[begin]=0;
			begin++;
		}
	}
}
