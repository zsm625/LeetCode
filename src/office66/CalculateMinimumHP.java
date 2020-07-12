package office66;

import java.util.Arrays;

/**
 * 地下城游戏
 * @author ZSM
 *
 * @time 2020年7月12日下午1:27:36
 */
public class CalculateMinimumHP {

	 public int calculateMinimumHP(int[][] dungeon) {
	        int n = dungeon.length, m = dungeon[0].length;
	        int[][] dp = new int[n + 1][m + 1];
	        for (int i = 0; i <= n; ++i) {
	            Arrays.fill(dp[i], Integer.MAX_VALUE);
	        }
	        dp[n][m - 1] = dp[n - 1][m] = 1;
	        for (int i = n - 1; i >= 0; --i) {
	            for (int j = m - 1; j >= 0; --j) {
	                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
	                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
	            }
	        }
	        return dp[0][0];
	    }

}
