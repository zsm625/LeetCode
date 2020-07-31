package dailyquestion.d_2020_07_31;

/**
 * 魔术索引
 * 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
 * 给定一个有序整数数组编写一种方法找出魔术索引，
 * 若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。
 * 若有多个魔术索引，返回索引值最小的一个。
 * @author ZSM
 *
 * @time 2020年7月31日上午7:58:37
 */
public class FindMagicIndex {
	
	/**
	 * 暴力遍历，时间复杂度为O(N)
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int findMagicIndex(int[] nums) {
		if(nums.length==0) {
			return -1;
		}
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==i) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 二分查找
	 * 考虑当nums[0]>0时
	 * nums[0]<0时出现的情况
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int findMagicIndex2(int[] nums) {
		if(nums.length==0) {
			return -1;
		}
		if(nums[0]==0) {
			return 0;
		}
		int left = 0,right=nums.length-1;
		boolean b = nums[0]>0;
		while(left<right) {
			int mid = left+(right-left+1)/2;
			if(b?nums[mid]<mid:nums[mid]>mid) {
				right=mid-1;
			}else {
				left++;
			}
		}
		return nums[left]==left?left:-1;
	}
	public static void main(String[] args) {
		FindMagicIndex index = new FindMagicIndex();
		int[] nums= {-1,0,1,2,4,5};
		int i = index.findMagicIndex2(nums);
		System.out.println(i);
	}
}
