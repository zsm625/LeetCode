package office66;

/**
 * 青蛙跳阶梯
 * 分析式与斐波那契数列一样
 * @author ZSM
 *
 * @time 2020年3月15日上午9:54:34
 */
public class NumWays {
	
	/**
	 * 常规的递归，性能太低
	 * 可以使用动态规划，用一个数组来记录
	 * 
	 *@author ZSM
	 * @param n
	 * @return
	 */
	public int numWays(int n) {
		if(n<=1) {
			return 0;
		}
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3;i<n+1;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
 
	public int numWay2(int n) {
		int a = 1,b = 1,sum;
		for(int i=0;i<n;i++) {
			sum = (a+b)%1000000007;
			a = b;
			b = sum;
		}
		return a;
	}
}
