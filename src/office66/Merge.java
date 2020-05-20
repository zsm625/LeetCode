package office66;

/**
 * 合并两个有序数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
 *  编写一个方法，将 B 合并入 A 并排序。
 *  初始化 A 和 B 的元素数量分别为 m 和 n。
 *  
 *  A = [1,2,3,0,0,0], m = 3
 *  B = [2,5,6],       n = 3
 *  输出: [1,2,2,3,5,6]
 * @author ZSM
 *
 * @time 2020年3月3日下午7:41:41
 */
public class Merge {

	/**
	 * 思路：将A数组的值与B数组的值进行比较，使用一个新的数组，大小为m+n
	 * 
	 *@author ZSM
	 * @param A
	 * @param m
	 * @param B
	 * @param n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) { 
		// two get pointers for nums1 and nums2
	    int p1 = m - 1;
	    int p2 = n - 1;
	    // set pointer for nums1
	    int p = m + n - 1;

	    // while there are still elements to compare
	    while ((p1 >= 0) && (p2 >= 0))
	      // compare two elements from nums1 and nums2 
	      // and add the largest one in nums1 
	      nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

	    // add missing elements from nums2
	    System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
	}
	public static void main(String[] args) {
		Merge merge = new Merge();
		int[] A = {4,0,0,0,0,0};
		int[] B = {1,2,3,5,6};
		merge.merge(A, 1, B, 5);
		for(int i=0;i<A.length;i++) {
			System.out.print(A[i]+"\t");
		}
	}
}
