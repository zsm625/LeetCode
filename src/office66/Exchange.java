package office66;

/**
 * 给定顺序数组，使奇数位于偶数前 输入一个整数数组，
 * 实现一个函数来调整该数组中数字的顺序， 使得所有奇数位于数组的前半部分，
 * 所有偶数位于数组的后半部分。
 * 
 * @author ZSM
 *
 * @time 2020年6月5日上午10:48:25
 */
public class Exchange {

	/**
	 * 采用的是快慢指针
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int[] exchange(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		int slow = 0;
		for (int fast = 1; fast < nums.length; fast++) {
			if(slow==0 && nums[slow]%2!=0) {
				slow++;
			}
			if (nums[fast] % 2 != 0) {
				int temp = nums[slow];
				nums[slow] = nums[fast];
				nums[fast] = temp;
				slow++;
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		Exchange exchange = new Exchange();
		int[] nums = { 1,  3,  5 };
		int[] is = exchange.exchange(nums);
		for (int i = 0; i < is.length; i++) {
			System.out.print(is[i] + "\t");
		}

	}
}
