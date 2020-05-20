package sort;

/**
 * 希尔排序是一种改进版的插入排序，适用于大数量且多是有序的数据排序 希尔排序就是将一组数分组进行排序，，通过一个增量来控制循环条件（gap=gap/2)
 * 将分隔gap的数进行比较，得到新的排序数组
 * 
 * @author ZSM
 *
 * @time 2019年10月7日下午4:47:58
 */
public class ShellSort {

	public int[] shell(int[] arr) {
		int gap = arr.length;
		while (gap >= 2) {
			gap = gap / 2;
			for (int i = gap; i < arr.length / gap; i++) {
				
			}
		}

		return arr;
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		ShellSort sort = new ShellSort();
		int[] arr = { 7, 3, 8, 5, 1, 2 };
		int[] shell = sort.shell(arr);
		for (int i = 0; i < shell.length; i++) {
			System.out.print(shell[i]);
		}
	}
}
