package sort;
/**
 * 选择排序
 * @author ZSM
 *
 * @time 2019年10月7日下午2:20:47
 */
public class ChooseSort {

	/**
	 * 选择排序的思路：
	 * 选择一个最小的值与数组的第一个数进行交换，然后依次递归
	 * 选择排序需要n^2/2次比较，n次交换
	 *@author ZSM
	 */
	public int[] selection(int[] arr) {
		if(arr==null|| arr.length==0) {
			System.out.println("请输入正确的数值");
		}
		for(int i=0;i<arr.length-1;i++) {
			int min = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[min]>arr[j]) {
				   min=j;
				}
			}
			swap(arr, i, min);
		}
		return arr;
	}
	
	public void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
//		return arr;
	}
	public static void main(String[] args) {
		ChooseSort sort = new ChooseSort();
		int[] arr =  {3,5,2,4,1};
		int[] is = sort.selection(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.println(is[i]);
		}
	}
}
