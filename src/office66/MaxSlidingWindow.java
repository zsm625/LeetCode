package office66;

/**
 * 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * @author ZSM
 *
 * @time 2020年7月15日上午10:55:07
 */
public class MaxSlidingWindow {
	/**
	 * 暴力解法
	 * 性能难以言喻
	 *@author ZSM
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow(int[] nums,int k) {
		if(nums==null || nums.length==0 || k==0) {
			return new int[0];
		}
		int len = nums.length;
		int[] res = new int[len-k+1];
		for(int i=0;i<=len-k;i++) {
			int max = nums[i];
			for(int j=0+i;j<i+k;j++) {
				if(nums[j]>max) {
					max=nums[j];
				}
			}
			res[i]=max;
		}
		return res;
	}
	
	/**
	 * 双指针
	 * 
	 *@author ZSM
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow2(int[] nums,int k) {
		if(nums==null || nums.length==0 || k==0) {
			return new int[0];
		}
		int len = nums.length;
		int[] res = new int[len-k+1];
		int first = 0,last = 1;
		int max = nums[first];
		while(first<=len-k) {
			if(nums[last]>max) {
				max = nums[last];
			}
			if(last<first+k-1) {
				last++;
			}else {
				res[first] = max;
				first++;
				last=first+1;
				max = nums[first];
				
			}
		}
		return res;
	}

	public static void main(String[] args) {
		MaxSlidingWindow window = new MaxSlidingWindow();
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int[] is = window.maxSlidingWindow2(nums, 3);
		for (int i : is) {
			System.out.println(i);
		}
	}
}
