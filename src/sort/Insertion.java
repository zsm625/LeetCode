package sort;

/**
 * 插入排序
 *
 * @author ZSM
 *
 * @time 2019年10月7日下午3:54:48
 */
public class Insertion {

	/**
	 * 插入排序的第一种:最坏的一种，没有排序 思路：从数组的第二个元素开始往前比较， 如果小于它，就将前面元素往后移一位直到，该元素大于其中某一个元素
	 * 有n^2/2次比较，n^2/2次交换，其中最坏情况下是倒序
	 * @author ZSM
	 * @param arr
	 * @return
	 */
	public int[] insertion(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int t=i;
			for (int j = i - 1; j >= 0 && arr[j] > arr[t]; j--) {
				int temp = arr[t];
				arr[t] = arr[j];
				arr[j] = temp;
				t--;
			}
//				arr[j]=temp;
		}

		return arr;
	}

	public static void main(String[] args) {
		Insertion insertion = new Insertion();
		int[] arr = { 7, 3, 8, 5, 1, 2 };
		int[] is = insertion.insertion(arr);
		for (int i = 0; i < is.length; i++) {
			System.out.println(is[i]);
		}
	}
}
