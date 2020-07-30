package dailyquestion.d_2020_07_29;

/**
 * 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，
 * 并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * @author ZSM
 *
 * @time 2020年7月30日上午7:47:50
 */
public class IntegerBreak {

	/**
	 * 动态规划
	 *@author ZSM
	 * @param n
	 * @return
	 */
	public int integerBreak(int n) {
		int[] dp = new int[n+1];
		dp[1]=1;
		dp[2] = 1;
		for(int i=3;i<n+1;i++) {
			for(int j=1;j<i;j++) {
				dp[i]=Math.max(dp[i], Math.max(dp[i-j],i-j)*j);
			}
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		IntegerBreak break1 = new IntegerBreak();
		int i = break1.integerBreak(57);
		System.out.println(i);
	}
}
