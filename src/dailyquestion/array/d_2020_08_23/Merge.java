package dailyquestion.array.d_2020_08_23;

/**
 * Merge sorted Array
 * Given two sorted integer arrays nums1 and nums2, 
 * merge nums2 into nums1 as one sorted array
 * @author Administrator
 *
 */
public class Merge {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if(m==0) {
			for(int i=0;i<m+n;i++) {
				nums1[i]=nums2[i];
			}
		}
		int left = m-1;
		int right = n-1;
		int i=nums1.length-1;
		while(i>=0) {
			if(left<0 || (right>=0&&nums1[left]<=nums2[right])) {
				nums1[i]=nums2[right];
				right--;
				i--;
			}else {
				int temp=nums1[i];
				nums1[i] = nums1[left];
				nums1[left] = temp;
				left--;
				i--;
			}
		}
	}
	public static void main(String[] args) {
		Merge merge = new Merge();
		int[] nums1= {1,2,3,0,0,0};
		int[] nums2= {2,5,6};
		merge.merge(nums1, 3, nums2, 3);
	}
}
