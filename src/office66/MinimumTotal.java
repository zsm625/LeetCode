package office66;

import java.util.List;

/**
 * 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 
 * @author ZSM
 *
 * @time 2020年7月14日下午4:53:48
 */
public class MinimumTotal {
	/**
	 * 使用动态规划
	 * 转移方程：
	 * dp[j] = min(dp[j+1],dp[j])+triangle[i][j];
	 * 
	 *@author ZSM
	 * @param triangle
	 * @return
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle == null) {
			return 0;
		}
		int row = triangle.size();
		int[] dp = new int[row+1];
		for(int i=row-1;i>=0;i--) {
			for(int j=0;j<triangle.get(i).size();j++) {
				dp[j] = Math.min(dp[j], dp[j+1])+triangle.get(i).get(j);
			}
		}
		return dp[0];
	}

}
