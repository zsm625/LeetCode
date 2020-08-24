package dailyquestion.array.d_2020_08_24;

/**
 * Remove Duplicates
 * Given a sorted array nums, 
 * remove the duplicates in-place 
 * such that each element appear only once and 
 * return the new length.
 * @author Administrator
 *
 */
public class RemoveDuplicates {

	public int removaDuplicates(int[] nums) {
		int begin = 1;
		int temp = nums[0];
		for(int i=1;i<nums.length;i++) {
			if(nums[i]!=temp) {
				nums[begin++] = nums[i];
				temp=nums[i];
			}
		}
		return begin;
	}
	
	public static void main(String[] args) {
		RemoveDuplicates duplicates = new RemoveDuplicates();
		int[] nums = {1,1,2,2,2,3,3,4,5};
		int i = duplicates.removaDuplicates(nums);
		System.out.println(i);
	}
}
