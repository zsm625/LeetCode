package dailyquestion.array.d_2020_08_22;

/**
 * Squares of a Sorted Array
 * Given an array of integers A sorted in non-decreasing order,
 * return an array of the squares of each number, 
 * also in sorted non-decreasing order.
 * 给定一个升序数组，将数组中的数字平方后并排序
 * @author Administrator
 *
 */
public class SortedSquares {

	/**
	 * 先得到负数与正数之间的分界线
	 * 然后根据分界线，分别正序和反序进行遍历，左边是由负数转变的，右边是正数，依次比较大小，将其加入到结果集中
	 * @param nums
	 * @return
	 */
	public int[] sortedSquares(int[] nums) {
		//先将数组中小于0的数字
		int left = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>=0) {
				break;
			}else {
				nums[i]=-nums[i];
				left=i;
			}
		}
		int right=left+1;
		int[] res = new int[nums.length];
		for(int i=0;i<nums.length;i++) {
			if(left>=0 && (right>nums.length-1 || nums[left]<=nums[right])) {
				res[i] = nums[left]*nums[left];
				left--;
			}else if(right<=nums.length-1 && (left<0 || nums[right]<nums[left])) {
				res[i] = nums[right]*nums[right];
				right++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		SortedSquares squares = new SortedSquares();
		int[] nums = {-7,-3,2,3,11};
		int[] is = squares.sortedSquares(nums);
		for (int i : is) {
			System.out.println(i);
		}
		
	}
}
