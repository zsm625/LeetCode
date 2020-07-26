package office66;

/**
 * 矩阵中的最长递增路径
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。
 *  你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 *  
 *  输入: nums = 
 *  [
 *     [9,9,4],
 *     [6,6,8],
 *     [2,1,1]
 *  ] 
 *  输出: 4 解释: 最长递增路径为 [1, 2, 6, 9]。
 *  
 * @author ZSM
 *
 * @time 2020年7月26日上午8:59:01
 */
public class LongestIncreasingPath {

	/**
	 * 深度优先遍历+记忆法
	 * 思路：从某一个元素开始遍历，找到四周比它小的最大连续递增长度，
	 * 四周比它小的数递归，继续重复前面的操作，直到找到能返回一个最大连续递增长度
	 * 而查询数四周比它小的数的最大增长长度+1就是查询数的最大增长长度
	 * 然后对每个数的最大增长长度进行比较
	 * 得到该矩形格的最大增长长度
	 * 
	 * 
	 *@author ZSM
	 * @param matrix
	 * @return
	 */
	public int longestIncreasingPath(int[][] matrix) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0) {
			return 0;
		}
		//作为记忆表，标记哪些单元格已经被访问过
		int[][] visited = new int[matrix.length][matrix[0].length];
		int max = 0;
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(visited[i][j]==0) {
					max = Math.max(max, dfs(matrix,i,j,visited));
				}
			}
		}
		return max;
	}
	
	/**
	 * 深度优先遍历
	 *@author ZSM
	 * @param matrix
	 * @param i
	 * @param j
	 * @return
	 */
	public int dfs(int[][] matrix,int i,int j,int[][] visited) {
		//递归终止条件
		if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length ) {
			return 0;
		}
		if(visited[i][j]>0) {
			return visited[i][j];
		}
		int maxTemp = 0;
		//上边
		if(i-1>=0 && matrix[i-1][j]<matrix[i][j]) {
			maxTemp = Math.max(maxTemp, dfs(matrix,i-1,j,visited));
		}
		//右边
		if(j+1<matrix[0].length && matrix[i][j]>matrix[i][j+1]) {
			maxTemp = Math.max(maxTemp, dfs(matrix,i,j+1,visited));
		}
		//左边
		if(j-1>=0 && matrix[i][j-1]<matrix[i][j]) {
			maxTemp = Math.max(maxTemp, dfs(matrix,i,j-1,visited));
		}
		//下边
		if(i+1<matrix.length && matrix[i][j]>matrix[i+1][j]) {
			maxTemp = Math.max(maxTemp, dfs(matrix,i+1,j,visited));
		}
		visited[i][j] = maxTemp+1;
		return maxTemp+1;
	}
	public static void main(String[] args) {
		LongestIncreasingPath path = new LongestIncreasingPath();
		int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
		int i = path.longestIncreasingPath(matrix);
		System.out.println(i);
	}
}
