package office66;

/**
 * 找出两组数组最长公共子序长
 * 给两个整数数组 A 和 B ，
 * 返回两个数组中公共的、长度最长的子数组的长度。
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3, 2, 1] 。
 * @author ZSM
 *
 * @time 2020年7月1日下午11:06:10
 */
public class FindLength {

	/**
	 * 动态规划
	 *@author ZSM
	 * @param A
	 * @param B
	 * @return
	 */
	public int findLength(int[] A,int[] B) {
		int[][] dp = new int[A.length+1][B.length+1];
		int max = 0;
		for(int i=1;i<=A.length;i++) {
			for(int j=1;j<=B.length;j++) {
				if(A[i-1]==B[j-1]) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j]=0;
				}
				max=Math.max(max, dp[i][j]);
			}
		}
		return max;
	}
}
