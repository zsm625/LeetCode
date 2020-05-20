package office66;

public class Massage {

	/**
	 * 动态规划————>自底向上，从最简单的开始推，重复子操作，记录每一次的结果
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int massage(int[] nums) {
		if(nums==null || nums.length==0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1]  = Math.max(nums[0], nums[1]);
		for(int i=2;i<nums.length;i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
		}
		
		return dp[nums.length-1];
	}
	
	public int massage2(int[] nums) {
		if(nums==null || nums.length==0) {
			return 0;
		}
		int a =0,b = 0;
		for(int i=0;i<nums.length;i++) {
			int sum = Math.max(b,a+nums[i]);
			a= b;
			b = sum;
		}
		return b;
	}
	
	public static void main(String[] args) {
		Massage massage = new Massage();
		int[] nums = {2,1,1,2};
		int i = massage.massage2(nums);
		System.out.println(i);
		
	}
}
