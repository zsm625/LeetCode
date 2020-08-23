package dailyquestion.array.d_2020_08_23;

/**
 * duplicateZeros
 * Given a fixed length array arr of integers, 
 * duplicate each occurrence of zero, 
 * shifting the remaining elements to the right.
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place,
 * do not return anything from your function.
 * 遇0添0，原数组大小，超过就挤出去
 * @author Administrator
 *
 */
public class DuplicateZeros {

	/**
	 * 暴力执法，时间复杂度太高O(n*n)
	 * @param nums
	 */
	public void duplicateZeros(int[] nums) {
		int i=0;
		while(i<nums.length) {
			if(nums[i]==0 && i<nums.length-1) {
				//往后移
				swap(nums,i);
				i++;
				nums[i]=0;
			}
			i++;
		}
	}
	public void swap(int[] nums,int start) {
		for(int i=nums.length-1;i>start;i--) {
			nums[i]=nums[i-1];
		}
	}
	
	public void duplicateZeros2(int[] nums) {
		int sh=0;
		int i=0;
		for(i=0;sh+i<nums.length;i++) {
			sh +=nums[i]==0?1:0;
		}
		
		for(i=i-1;sh>0;i--) {
			if(i+sh<nums.length) {
				nums[i+sh]=nums[i];
			}
			if(nums[i]==0) {
				sh--;
				nums[i+sh]=0;
			}
		}
	}
	public static void main(String[] args) {
		DuplicateZeros zeros = new DuplicateZeros();
		int[] nums = {1,0,2,3,0,4,5,0};
		zeros.duplicateZeros2(nums);
	}
}
