package office66;

/**
 * 在一个 n * m 的二维数组中，
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * @author ZSM
 *
 * @time 2020年4月17日下午5:28:12
 */
public class FindNumberIn2DArray {

	/**
	 * 解法一：暴力解法
	 * 时间复杂度为O（n*m）
	 * 空间复杂度为O（1）
	 *@author ZSM
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if(matrix==null || matrix.length==0) {
			return false;
		}
		 int row = matrix.length, col = matrix[0].length;
		 for(int i=0;i<row;i++) {
			 for(int j=0;j<col;j++) {
				 if(matrix[i][j]==target) {
					 return true;
				 }
			 }
		 }
		 
		 return false;
	}
	
	/**
	 * 从右上角开始遍历
	 * 如果为目标值就return true
	 * 如果当前值>目标值，就往左走
	 * 当前值<目标值，就往下走
	 * 直到行列的边界值
	 *@author ZSM
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean findNumberIn2DArray2(int[][] matrix,int target) {
		if(matrix==null || matrix.length==0) {
			return false;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int row = 0,col = cols-1;
		while(row<rows && col>=0) {
			int num = matrix[row][col];
			if(num==target) {
				return true;
			}else if (num>target) {
				col--;
			}else {
				row++;
			}
		}
		return false;
	}
	
	public boolean findNumberIn2DArray3(int[][] matrix,int target) {
		if(matrix==null || matrix.length==0) {
			return false;
		}
		int col = matrix[0].length-1,row = 0;
		while(row<matrix.length&& col>=0) {
			if(matrix[row][col]>target) {
				row++;
			}else if(matrix[row][col]>target) {
				col--;
			}else {
				return true;
			}
		}
		return false;
	}
}
