package office66;

/**
 * 获得最小的k个数
 * 输入整数数组 arr ，
 * 找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，
 * 则最小的4个数字是1、2、3、4。
 * @author ZSM
 *
 * @time 2020年7月24日上午8:08:33
 */
public class GetLeastNumbers {

	/**
	 * 排序 ，取出前k个数
	 *@author ZSM
	 * @param arr
	 * @param k
	 * @return
	 */
	public int[] getLeastNumbers(int[] arr,int k) {
		if(arr==null || arr.length==0 || k<=0) {
			return new int[0];
		}
		mergeSort(arr,0,arr.length-1);
		int[] res = new int[k];
		for(int i=0;i<k;i++) {
		    res[i] = arr[i];	
		}
		return res;
	}
	
	private void mergeSort(int[] arr,int left,int right) {
		if(left>right) {
			return;
		}
		int mid = (left+right)/2;
		mergeSort(arr,left,mid);
		mergeSort(arr,mid+1,right);
		int[] temp = new int[right-left+1];
		int i=left,j=mid+1;
		int curr = 0;
		while(i<=mid && j<=right ) {
			if(arr[i]<=arr[j]) {
				temp[curr] = arr[i++];
			}else {
				temp[curr] = arr[j++];
			}
			curr++;
		}
		//这两个是为了防止当左右的数组不均衡时，将多余的也添加到数组中；
		while (i <= mid) {
			temp[curr++] = arr[i++];
		}
		while (j <= right) {
			temp[curr++] = arr[j++];
		}
		// 合并完毕，将结果拷贝到原数组中去
		for (int k = 0; k < temp.length; k++) {
			arr[left + k] = temp[k];
		}
	}
}
