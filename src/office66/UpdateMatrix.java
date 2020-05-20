package office66;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 矩阵0,1找数字距离0的位置
 * @author ZSM
 *
 * @time 2020年4月15日下午1:07:29
 */

public class UpdateMatrix {

	/**
	 * 遍历
	 *@author ZSM
	 * @param matrix
	 * @return
	 */
	public int[][] updateMatrix(int[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] vector = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
		Queue<int[]> queue = new LinkedList<>();
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(matrix[i][j]==0) {
					queue.add(new int[] {i,j});
				}else {
					matrix[i][j]=row+col;
				}
			}
		}
		while(!queue.isEmpty()) {
			int[] s = queue.poll();
			for(int[] v:vector) {
				int r=s[0]+v[0];
				int c = s[1]+v[1];
				if(r>=0&&r<row&&c>=0&&c<col) {
					if(matrix[r][c]>=matrix[s[0]][s[1]]+1) {
						matrix[r][c] = matrix[s[0]][s[1]]+1;
						queue.add(new int[] {r,c});
					}
				}
			}
		}
		return matrix;
	}
}
