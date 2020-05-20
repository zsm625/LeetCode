package office66;

/**
 * 找到数组中只出现过一次的序列
 * @author ZSM
 *
 * @time 2020年4月9日上午11:56:55
 */
public class SingleNumbers {

	/**
	 * 利用异或运算的规律来交换
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int[] singleNumbers(int[] nums) {
		if(nums==null || nums.length==0) {
			return new int[0];
		}
		
		int x = 0;
		for(int i=0;i<nums.length;i++) {
			x^=nums[i];
		}
		//得到最低位1
		int flag = x&(-x);
		int res = 0;
		for(int num:nums) {
			if((flag&num) !=0 ) {
				res^=num;
			}
		}
		return new int[] {res,res^x};
	}
}
