package dailyquestion.array.d_2020_08_29;

/**
 * Height Checker
 * Students are asked to stand in non-decreasing order of heights 
 * for an annual photo.
 * Return the minimum number of students 
 * that must move in order for all students 
 * to be standing in non-decreasing order of height.
 * 给学生排队，从低到高，最小的移动次数
 * @author zsm
 *
 *     时间：2020年8月29日
 */
public class HeightChecker {

	/**
	 * 这题目出的有问题
	 * @param A
	 * @return
	 */
	public int heightChecker(int[] A) {
		if(A.length==0) {
			return 0;
		}
		int res = 0;
		//简单粗暴的冒泡排序
		for(int i=A.length-1;i>=0;i--) {
			for(int j=0;j<i;j++) {
				if(A[j]>A[i]) {
					res++;
					int tmp = A[j];
					A[j] = A[i];
					A[i] = tmp;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		HeightChecker checker = new HeightChecker();
		int[] A = {5,1,2,3,4};
		int i = checker.heightChecker(A);
		System.out.println(i);
		
	}
}
