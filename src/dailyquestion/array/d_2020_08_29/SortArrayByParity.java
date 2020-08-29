package dailyquestion.array.d_2020_08_29;

/**
 * Sort Array ByParity
 * Given an array A of non-negative integers, 
 * return an array consisting of all the even elements of A, 
 * followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 * @author zsm
 *
 *     时间：2020年8月29日
 */
public class SortArrayByParity {

	public int[] sortArrayByParity(int[] A) {
		if(A.length==0) {
			return new int[0];
		}
		int i=0,j=A.length-1;
		int[] res = new int[A.length];
		for (int num : A) {
			if(num%2==0) {
				res[i++]=num;
			}else {
				res[j--]=num;
			}
		}
		return res;
	}
	
	public int[] sortArrayByParity2(int[] A) {
		if(A.length==0) {
			return A;
		}
		for(int i=0,j=0;i<A.length;i++) {
			if((A[i]&1)==0) {
				int temp = A[i];
				A[i] = A[j];
				A[j++] = temp;
			}
		}
		return A;
	}
}
