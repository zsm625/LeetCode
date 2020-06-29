package office66;

/**
 * 数组中第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，
 * 而不是第 k 个不同的元素。
 * @author ZSM
 *
 * @time 2020年6月29日下午9:36:34
 */
public class FindKthLargest {

	/**
	 * 小顶堆
	 * 求第K大或第K小，一般思路就是构建一个只有K个节点的堆，
	 * 最后返回堆顶。
	 *@author ZSM
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargest(int[] nums,int k) {
		buildHeap(nums,k);
		for(int i=k;i<nums.length;i++) {
			if(nums[i]<nums[0]) {
				continue;
			}
			swap(nums,i,0);
			heapify(nums,k,0);
		}
		return nums[0];
	}
	
	
	public void buildHeap(int[] nums,int k){
		for(int i=k/2-1;i>=0;i--) {
			heapify(nums,k,i);
		}
	}
	public void heapify(int[] nums,int k,int i) {
		int minPos = i;
		while(true) {
			int left = i*2+1;
			int right = i*2+2;
			//左子树比根小，将最小值记录为左子树
			if(left<k&&nums[left]<nums[minPos]) {
				minPos=left;
			}
			if(right<k && nums[right]<nums[minPos]) {
				minPos=right;
			}
			if(minPos==i) {
				break;
			}
			swap(nums,minPos,i);
			i=minPos;
		}
	}
	public void swap(int[] nums,int i,int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void main(String[] args) {
		FindKthLargest largest = new FindKthLargest();
		int[] nums = {3,2,3,1,2,4,5,5,6};
		int i = largest.findKthLargest(nums, 2);
		System.out.println(i);
	}
}
