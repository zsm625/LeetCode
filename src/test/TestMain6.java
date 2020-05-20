package test;

import java.util.Arrays;

/**
 * 测试时间复杂度
 * 
 * @author ZSM
 *
 * @time 2019年10月25日下午9:08:40
 */
public class TestMain6 {
	int array[] = new int[10];
	int len = 10;
	int i = 0;

	public void add(int element) {
		if (i >= len) {
			// 数组空间不够了
			// 重新申请一个2倍大小的数组空间
			int new_array[] = new int[len * 2];
			// 把原来array数组中的数据依次copy到new_array
			for (int j = 0; j < len; ++j) {
				new_array[j] = array[j];
			}
			// new_array复制给array，array现在大小就是2倍len了
			array = new_array;
			len = 2 * len;
			System.out.println(Arrays.toString(array));
		} // 将element放到下标为i的位置，下标i加一
		array[i] = element;
		++i;
		System.out.println(array[i]);
	}
	public static void main(String[] args) {
		TestMain6 main6 = new TestMain6();
		main6.add(10);
	}
}
