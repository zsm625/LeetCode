package office66;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * @author ZSM
 *
 * @time 2020年3月14日上午9:00:18
 */
public class LengthOfLis {

	/**
	 * 使用动态规划
	 * 这个答案没太懂
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
		if(nums==null || nums.length==0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0]=1;
		int maxans = 1;
		for(int i=1;i<dp.length;i++) {
			int maxval = 0;
			for(int j =0;j<i;j++) {
				if(nums[i]>nums[j]) {
					maxval = Math.max(maxval, dp[j]);
				}
			}
			dp[i] = maxval+1;
			maxans = Math.max(maxans, dp[i]);
		}
		return maxans;
	}
	
	/**
	 * 没弄明白
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS2(int[] nums) {
		if(nums==null || nums.length==0) {
			return 0;
		}
		int res = 0;
		int[] help = new int[nums.length];
		for (int num : nums) {
			int i=0; int j = res;
			while(i<j) {
				int m = (i+j)/2;
				if(help[m]<num) {
					i = m+1;
				}else {
					j=m;
				}
			}
			help[i] = num;
			if(res==j) {
				res++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		LengthOfLis lis = new LengthOfLis();
		int[] nums= {1,3,6,7,9,4,10,5,6};
		int len = lis.lengthOfLIS(nums);
		System.out.println(len);
	}
}
