package office66;

/**
 * 投股票的最佳时期
 * 
 * @author ZSM
 *
 * @time 2020年3月9日下午5:19:19
 */
public class MaxProfit {
	/**
	 * 
	 *@author ZSM
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if(prices==null || prices.length==0) {
			return 0;
		}
		int p1=prices[0];
		int max = 0;
		for(int i=1;i<prices.length;i++) {
			if(p1>prices[i]) {
				p1= prices[i];
			}else if(prices[i]-p1>max) {
				max = prices[i]-p1;
			}
		}
		return max;
	}

	/**
	 * 升级版 股票最大利润 添加了冷冻期
	 * 买入，卖出 ，冷冻期 ，买入，卖出
	 * 冷冻期只有在不持有股票期才有
	 * 就只有两种状态：持有股票、不持有股票
	 * 用动态规划
	 * dp[i][j],i为第i天，j为两种状态：0（持有）,1（不持有在冷冻期），2（不持有不在冷冻期）
	 * dp[i][0]=max(dp[i-1][0],prices[i]-dp[i-1][2])
	 * dp[i][1]=prices[i]+dp[i-1][0];
	 * dp[i][2]=max(dp[i-1][1],dp[i-1][2]);
	 * 
	 *@author ZSM
	 * @param prices
	 * @return
	 */
	public int maxProfit2(int[] prices) {
		if(null==prices || prices.length==0) {
			return 0;
		}
		int n = prices.length;
		int[][] dp = new int[n][3];
		dp[0][0] = -prices[0];
		for(int i=1;i<n;i++) {
			dp[i][0]=Math.max(dp[i-1][0], dp[i-1][2]-prices[i]);
			dp[i][1] = dp[i-1][0]+prices[i];
			dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
		}
		return Math.max(dp[n-1][1], dp[n-1][2]);
	}
	public static void main(String[] args) {
		MaxProfit profit = new MaxProfit();
		int[] prices = {7,3,1,4,6,5};
		int i = profit.maxProfit(prices);
		System.out.println(i);
	}
}
