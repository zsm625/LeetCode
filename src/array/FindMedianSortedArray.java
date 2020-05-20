package array;

import java.util.Arrays;

/**
 * 从两个有序数组中找出他们的中位数
 * 并且要求算法的时间复杂度为 O(log(m + n))
 * 思路：
 * 将两个数组组成一个数组，通过新数组的长度找到中间两个除以2或者最中间的值
 * @author ZSM
 *
 * @time 2019年10月29日下午2:38:03
 */
public class FindMedianSortedArray {
	public double findMedian(int[] nums1,int[] nums2) {
		double result = 0;
		int len1 = nums1.length;
		int len2 = nums2.length;
		
		int[] temp = Arrays.copyOf(nums1, len1+len2);
		for(int i=0;i<len2;i++) {
			temp[len1+i]=nums2[i];
		}
		int len = temp.length;
		if(len%2==0) {
			result = (double)(temp[(len-1)/2]+temp[len/2])/2;
		}else {
			result = temp[len/2];
		}
		return result;
	}
	
	public static void main(String[] args) {
		FindMedianSortedArray array = new FindMedianSortedArray();
		int[] nums1= {1, 2};
		int[] nums2= {3};
		double median = array.findMedian(nums1, nums2);
		System.out.println(median);
	}
}
