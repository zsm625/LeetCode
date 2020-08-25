package dailyquestion.array.d_2020_08_25;

/**
 * Valid Mountain Array
 * Given an array A of integers, 
 * return true if and only if it is a valid mountain array.
 * @author Administrator
 *
 */
public class ValidMountainArray {

	public boolean validMountainArray(int[] A) {
		if(A.length==0) {
			return false;
		}
		int N = A.length;
		int i=0;
		while(i+1<N && A[i]<A[i+1]) {
			i++;
		}
		if(i==0 || i==N-1) {
			return false;
		}
		
		while(i+1<N && A[i]>A[i+1]) {
			i++;
		}
		return  i==N-1;
	}
}
