package office66;

public class MaxSubArray {
	/**
	 * 返回的是连续子序列的最大和
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		if(nums==null || nums.length==0) {
			return -1;
		}
		int max = nums[0],sum = nums[0];
		for(int i=1;i<nums.length;i++) {
			sum+=nums[i];
			if(sum<nums[i]) {
				sum = nums[i];
			}
			if(sum>max) {
				max = sum;
			}
		}
		
		
		return max;
	}
	
	/**
	 * 返回连续子序列和最大的子数组
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int[] maxSubArray2(int[] nums) {
		if(nums==null || nums.length==0) {
			return null;
		}
		int p1 = 0,p2 = 0,sum = nums[0],max = nums[0];
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
			if(sum<nums[i]) {
				sum = nums[i];
				p1 = i;
			}
			if(sum>max) {
				max = sum;
				p2 = i;
			}
		}
		int[] res = new int[p2-p1+1];
		for(int j=p1,k=0;j<=p2&& k<res.length;j++,k++) {
			res[k] = nums[j];
		}
		return res;
	}
	
	public static void main(String[] args) {
		MaxSubArray subArray = new MaxSubArray();
		int[] nums  = {-2,1,-3,4,-1,2,1,-5,4};
		int i = subArray.maxSubArray(nums);
		int[] js = subArray.maxSubArray2(nums);
		for (int j : js) {
			System.out.print(j+"\t");
		}
//		System.out.println(i);
		
	}
}
