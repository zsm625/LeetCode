package office66;

/**
 * 最长有效括号 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 
 * @author ZSM
 *
 * @time 2020年7月6日上午10:37:01
 */
public class LongestValidParentheses {

	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int maxans = 0;
		int[] dp = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
			}

			maxans = Math.max(maxans, dp[i]);
		}
		return maxans;
	}

}
