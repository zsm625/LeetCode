package office66;

/**
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，
 * 在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 * @author ZSM
 *
 * @time 2020年7月17日上午9:53:53
 */
public class SearchInsert {
	
	/**
	 * 二分查找法
	 * 时间复杂度为O(logn)
	 *@author ZSM
	 * @param nums
	 * @param target
	 * @return
	 */
	public int searchInsert(int[] nums,int target) {
		if(nums==null || nums.length==0) {
			return -1;
		}
		
		int len = nums.length;
		int left = 0,right = len-1, res = len;
		while(left<=right) {
			int mid = ((right-left)>>1)+left;
			if(target<=nums[mid]) {
				res = mid;
				right = mid-1;
			}else {
				left=mid+1;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		SearchInsert insert = new SearchInsert();
		int[] nums = {1,3,5,6};
		int i = insert.searchInsert(nums, 7);
		System.out.println(i);
	}
}
