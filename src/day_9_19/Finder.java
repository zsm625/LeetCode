package day_9_19;

/**
 * 二维数组的查找
 * 给定一个二维数组，
 * 其每一行从左到右递增排序，
 * 从上到下也是递增排序。
 * 给定一个数，判断这个数是否在该二维数组中。
 * @author ZSM
 *
 * @time 2019年9月22日上午10:55:29
 */
public class Finder {
	
	/**
	 * 思路：因为是一个左右，上下有序的二维数组，因此，可以从右上角的元素开始遍历，
	 * 当目标值大于元素时往下遍历，如果小于就往左遍历，直到找到target或者，
	 * j=0，或者i=length-1，j=length-1
	 *@author ZSM
	 * @param target
	 * @param matrix
	 * @return
	 */
	public boolean find(int target,int[][] matrix) {
		int i=0;
		int j= matrix[i].length-1;
		int temp = matrix[0][matrix[0].length-1];
		while(i<matrix.length&&j>0) {
			if(target==temp) {
				System.out.println(i+", "+j);
				return true;
			}
			if(target>temp) {
			    ++i;
				temp=matrix[i][j];
			}
			if(target<temp) {
				--j;
				temp=matrix[i][j];
			}
		}
		
		
		return false;
	}
	
	public static void main(String[] args) {
		Finder find = new Finder();
		int[][] matrix= {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},
				  {3,   6,  9, 16, 22},
				  {10, 13, 14, 17, 24},
				  {18, 21, 23, 26, 30}};
		System.out.println(find.find(20, matrix));
	}

}
