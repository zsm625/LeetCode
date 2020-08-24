package dailyquestion.array.d_2020_08_24;

/**
 * RemoveElement
 * Given an array nums and a value val, 
 * remove all instances of that value in-place and 
 * return the new length.
 * @author Administrator
 *
 */
public class RemoveElement {

	public int removeElement(int[] nums,int val) {
		int begin = 0;
		int n = nums.length;
		for(int i=0;i<n;i++) {
			if(nums[i]!=val) {
				nums[begin++] = nums[i];
			}
		}
		return begin;
	}
	
	public static void main(String[] args) {
		RemoveElement element = new RemoveElement();
		int[] nums = {0,1,2,2,3,0,4,2};
		element.removeElement(nums, 2);
	}
	
}
