package office66;

/**
 * 矩阵旋转
 * @author ZSM
 *
 * @time 2020年4月7日下午5:53:51
 */
public class Rotate {

	/**
	 * 先由对角线进行[1,5,9]
	 *@author ZSM
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
		if(matrix ==null || matrix.length==0) {
			return;
		}
		int len = matrix.length;
		for(int i=0;i<len;i++) {
			for(int j=i+1;j<len;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
			for(int j=0;j<len/2;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][len-1-j];
				matrix[i][len-1-j] = temp;
			}
		}
		
	}
}
