package office66;

/**
 * 除自身以外的数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * @author ZSM
 *
 * @time 2020年6月4日下午8:15:03
 */
public class ProductExceptSelf {

	/**
	 * 不能用除法进行计算，为了防止如果数组中有0
	 * 那就先计算当前数字左边的乘积，再从后序计算当前数字右边的乘积；
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
		if(nums==null || nums.length==0) {
			return new int[0];
		}
		int len = nums.length;
		int[] answer = new int[len]; 
		//第一个没有左边的数
		answer[0] = 1;
		//左边的乘积
		for(int i=1;i<len;i++) {
			answer[i] = nums[i-1]*answer[i-1];
		}
		
		int right = 1;
		//右边的乘积
		for(int j=len-1;j>=0;j--) {
			answer[j] = answer[j]*right;
			right*=nums[j];
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		ProductExceptSelf self = new ProductExceptSelf();
		int[] nums = {4,5,1,8,2};
		int[] is = self.productExceptSelf(nums);
		for (int i : is) {
			System.out.print(i+"\t");
		}
	}
}
