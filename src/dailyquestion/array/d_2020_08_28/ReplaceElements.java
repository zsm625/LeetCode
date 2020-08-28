package dailyquestion.array.d_2020_08_28;

/**
 * 
 * @author zsm
 *
 *         时间：2020年8月28日
 */
public class ReplaceElements {

	public int[] replaceElements(int[] arr) {
		if(arr.length==0) {
			return arr;
		}
		int maxCurr = -1;
		for(int i=arr.length-1;i>=0;i--) {
			int newMax = Math.max(arr[i], maxCurr);
			arr[i] = maxCurr;
			maxCurr = newMax;
		}
		return arr;
	}
}
