package office66;

import java.util.Arrays;

/**
 * 从旋转数组中找最小的值
 * 
 * @author ZSM
 *
 * @time 2020年4月10日下午12:24:59
 */
public class MinArray {
	/**
	 * 采用二分法
	 *@author ZSM
	 * @param numbers
	 * @return
	 */
	public int minArray(int[] numbers) {
		Arrays.sort(numbers, 0, 5);
		int i=0,j=numbers.length-1;
		while(i<j) {
			int mid = (i+j)/2;
			if(numbers[mid]>numbers[j]) {
				i=mid+1;
			}else if(numbers[mid]<numbers[j]) {
				j=mid;
			}else {
				j--;
			}
			
		}
		return numbers[i];
	}
}
