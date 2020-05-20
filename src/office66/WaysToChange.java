package office66;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 硬币
 * 给定数量不限的硬币，
 * 币值为25分、10分、5分和1分，
 * 编写代码计算n分有几种表示法。
 * (结果可能会很大，你需要将结果模上1000000007)
 * @author ZSM
 *
 * @time 2020年4月23日下午9:05:52
 */
public class WaysToChange {

	public int waysToChange(int n) {
		ConcurrentHashMap c;
		HashMap m;
		TreeMap t;
		Object o;
		int[] coins = new int[] {1,5,10,25};
		int[] dp = new int[n+1];
		dp[0] = 1;
		for(int coin:coins) {
			for(int i=1;i<=n;i++) {
				if(i-coin >=0) {
					dp[i] = (dp[i]+dp[i-coin])%1000000007;
				}
			}
		}
		return dp[n];
	}
}
