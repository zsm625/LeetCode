package office66;

/**
 * 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，
 * 请构建一个数组 B[0,1,…,n-1]，
 * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
 * 不能使用除法。
 * @author ZSM
 *
 * @time 2020年7月16日上午9:45:30
 */
public class ConstructArr {
	/**
	 * 计算对称两个三角
	 * 先计算下三角
	 * 再计算上三角
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int[] constructArr(int[] nums) {
		if(nums==null || nums.length==0) {
			return nums;
		}
		
		int[] res = new int[nums.length];
		res[0] = 1;
		int temp = 1;
		for(int i=1;i<nums.length;i++) {
			res[i] = res[i-1]*nums[i-1];
		}
		
		for(int j=nums.length-2;j>=0;j--) {
			temp*=nums[j+1];
			res[j]*=temp;
		}
		return res;
	}

}
