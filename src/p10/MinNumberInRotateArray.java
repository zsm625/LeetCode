package p10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 旋转数组的最下元素：
 * 思路：感觉这道题就是得理解题目意思，首先，旋转数组在在未旋转之前就是一个升序的数组，
 * 因此，只要找到前后不是升序的地方就是最小值所在的地方
 * 
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 * @author ZSM
 *
 * @time 2019年10月4日上午11:04:18
 */
public class MinNumberInRotateArray {
	
	/**
	 * 第一种方式：
	 * 根据旋转数组的特性，暴力寻找，空间复杂：O（1），时间：O(n)；
	 *@author ZSM
	 * @param array
	 * @return
	 */
	public int minNumberInRotateArray(int[] array)
	{
		if(array.length==0) {
			return 0;
		}
		for(int i=0;i<array.length-1;i++) {
			if(array[i]>array[i+1]&& i<array.length-2) {
				return array[i+1];
			}
		}
		
		return array[0];
	}
	
	/**
	 * 第二种就是，先升序排序，直接得到数组的第一个值
	 * 时间：O(nlogn),空间：O(1)
	 * 
	 *@author ZSM
	 * @param array
	 * @return
	 */
	public int minNumberInRotateArray2(int[] array) {
		if(array.length==0) {
			return 0;
		}
		
		Arrays.sort(array);
		return array[0];
	}
	
	public int minNUmberInRoteArray3(int[] array) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		if(array.length==0) {
			return 0;
		}
		for(int i=0;i<array.length;i++) {
			queue.add(array[i]);
		}
		return queue.poll();
	}
}
