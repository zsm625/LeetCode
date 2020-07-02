package office66;

/**
 * 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，
 * 其中每行和每列元素均按升序排序，
 * 找到矩阵中第 k 小的元素。
 * @author ZSM
 *
 * @time 2020年7月2日下午3:27:17
 */
public class KthSmallest {

	/**
	 * 很巧妙但是比较难懂的一个方式：二分法
	 * 
	 *@author ZSM
	 * @param matrix
	 * @param k
	 * @return
	 */
	public int kthSmallest(int[][] matrix,int k) {
		int len = matrix.length;
		int left = matrix[0][0];
		int right = matrix[len-1][len-1];
		
		//二分查找
		while(right>left) {
			int mid = left+(right-left)/2;
			//小于等于mid的值的数量小于k
			if(checkLessThanK(matrix,mid,k)) {
				left=mid+1;
			}else {
				right=mid;
			}
		}
		return left;
	}
	
	public boolean checkLessThanK(int[][] matrix,int mid,int k) {
		int num = 0;
		int col=0;
		int row = matrix.length-1;
		while(row>=0&&col<matrix.length) {
			if(matrix[row][col]<=mid) {
				col++;
				num+=row+1;
			}else {
				row--;
			}
			if(num>=k) return false;
		}
		return true;
	}
}
