package office66;

/**
 * 不同路径II
 * 给定一个矩阵，m*n，当元素为1时，代表有障碍物，此路不通
 * 
 * @author ZSM
 *
 * @time 2020年7月6日下午6:33:49
 */
public class UniquePathsWithObstacles {
	/**
	 * 
	 *@author ZSM
	 * @param obstacleGrid
	 * @return
	 */
	public int uniquePathWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0) {
			return 0;
		}
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m+1][n+1];
		dp[0][1] = 1;
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(obstacleGrid[i-1][j-1]==0) {
					dp[i][j] = dp[i][j-1]+dp[i-1][j];
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		UniquePathsWithObstacles obstacles = new UniquePathsWithObstacles();
		int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		int i = obstacles.uniquePathWithObstacles(obstacleGrid);
		System.out.println(i);
	}
}
