package office66;

/**
 * 希望通过这个排序，掌握基本的几种排序方式
 * @author ZSM
 *
 * @time 2020年3月31日上午9:04:14
 */

public class SortArray {
	/**
	 * 给定一组数，按照升序排好序并返回
	 * 方法一：快速排序
	 * 快排的主要思想是通过将待排序的序列划分成前后两部分，
	 * 其中前一部分的数据都比后一部分的数据要小，
	 * 然后再递归调用函数对两部分的序列分布进行快排，依次使整个序列达到有序
	 *@author ZSM
	 * @param nums
	 * @return
	 */
	public int[] sortArray(int[] nums) {
		if(nums==null || nums.length==0) {
			return null;
		}
		insertionSort(nums);
		return nums;
		
	}

	/**
	 * 冒泡排序，
	 * 比较前后相邻的两个元素，前一个元素比后一个元素大，就把他们互相交换
	 * 遍历一次数组之后，保证最后一个元素相对前面的元素是最大的；
	 * 重新遍历数组，保证第n-1个元素在n-1个元素前是最大的；
	 * 直到遍历元素，第2个元素是前两个元素的最大值
	 * 
	 * 时间复杂度为O(n^2)
	 * 空间复杂度为O(1)
	 *@author ZSM
	 * @param nums
	 */
	public void bubbleSort(int[] nums) {
		for(int i=nums.length-1;i<=1;i--) {
			for(int j=1;j<=i;j++) {
				if(nums[j-1]>nums[j]) {
					swap(nums,j,j-1);
				}
			}
		}
	}
	
	/**
	 * 选择排序
	 * 思路：先找到前n个元素中最大的值，
	 * 然后和最后一个元素交换，
	 * 这样保证最后一个元素一定是最大的，
	 * 然后找到前n-1个元素中的最大值和第n-1个元素进行交换，
	 * 然后找到前n-2个元素中最大值和第n-1个值进行交换，依次类推到第2哥元素
	 * 
	 * 时间复杂度为O(n^2)
	 * 空间复杂度为O(1)是一个原地算法
	 * 但选择排序是不稳定的排序
	 *@author ZSM
	 * @param nums
	 * 时间复杂度为O(n^2)
	 * 空间复杂度为O(1)是一个原地算法
	 * 但选择排序是不稳定的排序
	 */
	public void selectionSort(int[] nums) {
		for(int i=nums.length-1;i>0;i--) {
			int maxIndex = 0;
			for(int j=0;j<=i;j++) {
				if(nums[maxIndex]<nums[j]) {
					maxIndex=j;
				}
			}
			swap(nums,maxIndex,i);
		}
	}
	
	/**
	 * 插入排序
	 * 当是有序的数组时，时间复杂度为O(n),最坏仍是O(n^2)
	 * 空间复杂度为O(1)
	 * 稳定的排序
	 *@author ZSM
	 * @param nums
	 */
	public void insertionSort(int[] nums) {
		for(int i=1;i<nums.length;i++) {
			int j=i;
			while(j>0&&nums[j]<nums[j-1]) {
				swap(nums,j,j-1);
				j--;
			}
		}
	}
	
	/**
	 * 希尔排序
	 * 不稳定排序
	 * 时间复杂度很大程度取决于间距gap
	 *@author ZSM
	 * @param nums
	 */
	public void shellSort(int[] nums) {
		int gap = nums.length>>1;
			while(gap>0) {
				for(int i=0;i<gap;i++) {
					for(int j=i+gap;j<nums.length;j+=gap) {
						int temp = j;
						while(temp>i && nums[temp]<nums[temp-gap]) {
							swap(nums,temp,temp-gap);
							temp-=gap;
						}
								
					}
				}
				gap>>=1;
			}
	}
	
	/**
	 * 归并排序
	 * 时间复杂度为O(nlogn)
	 * 空间复杂度O(n)
	 *@author ZSM
	 * @param nums
	 * @param left
	 * @param right
	 */
	public void mergeSort(int[] nums,int left,int right) {
		if(left>=right) {
			return ;
		}
		int mid = (left+right)/2;
		mergeSort(nums,left,mid);
		mergeSort(nums,mid+1,right);
		//临时数组存放合并结果
		int[] temp = new int[right-left+1];
		int i=left,j=mid+1;
		int cur = 0;
		while(i<=mid && j<=right) {
			if(nums[i]<=nums[j]) {
				temp[cur] = nums[i++];
			}else {
				temp[cur] = nums[j++];
			}
			cur++;
		}
		//这两个是为了防止当左右的数组不均衡时，将多余的也添加到数组中；
		while(i<=mid) {
			temp[cur++]=nums[i++];
		}
		while(j<=right) {
			temp[cur++] = nums[j++];
		}
		//合并完毕，将结果拷贝到原数组中去
		for(int k=0;k<temp.length;k++) {
			nums[left+k]=temp[k];
		}
	}
	
	/**
	 * 第一种快排，选择第一个元素（或者最后一个元素）作为分界点
	 *@author ZSM
	 * @param nums
	 */
	public void quickSort(int[] nums,int left,int right){
		if(left>=right) {
			return;
		}
		int lo = left+1;
		int ri = right;
		while(lo<=ri) {
			if(nums[lo]>nums[left]) {
				swap(nums,lo,ri);
				ri--;
			}else {
				lo++;
			}
		}
		lo--;
		quickSort(nums,left,lo-1);
		quickSort(nums,lo+1,right);
		
	}
	
	/**
	 * 快速排序的第二种，取消ri来标记大于分界点元素的最右侧
	 * 时间复杂度为O(nlogn),最坏情况是O(n^2)
	 * 空间复杂度为O(logn),最坏的情况是O(n)
	 * 快排是不稳定的，因为包含跳跃式交换元素位置
	 *@author ZSM
	 * @param nums
	 * @param left
	 * @param right
	 */
	public void quickSort2(int[] nums,int left,int right) {
		if(left>=right) {
			return ;
		}
		int cur = left+1;
		int lo = left;
		while(cur<=right) {
			if(nums[cur]<=nums[left]) {
				swap(nums,lo+1,cur);
				lo++;
			}
			cur++;
		}
		swap(nums,left,lo);
		quickSort(nums,left,lo-1);
		quickSort(nums,lo+1,right);
	}
	
	/**
	 * 堆排序的时间复杂度为O(nlogn)
	 * 空间复杂度为O(1)
	 *@author ZSM
	 * @param nums
	 */
	public void heapSort(int[] nums) {
		heapify(nums);
		for(int i=nums.length-1;i>=0;i--) {
			swap(nums,0,i);
			rebuildHeap(nums,0,i-1);
		}
	}
	private void heapify(int[] nums) {
		for(int i=1;i<nums.length;i++) {
			//父节点
			int par = (i-1)>>1;
		    //子节点
		    int chird =i;
		    //从子节点到根节点构建最大堆
		    while(chird>0&&nums[par]<nums[chird]) {
		    	swap(nums,par,chird);
		    	chird = par;
		    	par = (par-1)>>1;
		    }
		}
	}
	
	private void rebuildHeap(int[] nums,int par,int last) {
		//左子结点
		int left = 2*par+1;
		//右子节点
		int right = 2*par+2;
		int maxIndex = left;
		//找到最大节点
		if(right<=last && nums[right]>nums[left]) {
			maxIndex = right;
		}
		//与最大子节点比较
		if(left<=last && nums[par]<nums[maxIndex]) {
			swap(nums,par,maxIndex);
			//重建最大子节点代表的子树
			rebuildHeap(nums,maxIndex,last);
		}
	}
	
	/**
	 * 定义基本的交换数组元素的方法
	 *@author ZSM
	 * @param nums
	 * @param i
	 * @param j
	 */
	private void swap(int[] nums,int i,int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
