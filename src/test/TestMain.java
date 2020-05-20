package test;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;

public class TestMain {

	static boolean foo(char c) {
		System.out.print(c);
		return true;
	}

	public static void main(String[] args) {
		int i = 0;
//		System.out.print("ss");
		OutputStream o;
		FileOutputStream p;
//		for (foo('A'); foo('B') && (i < 2); foo('C')) {
//			i++;
//			foo('D');
//		}
		TestMain test = new TestMain();
		int[] T= {1,2,3,5,6,7,11,13,15};
		test.test1(T, 16);
		String s;
	}
	
	/**
	 * 从最小值开始计算，得到最大的加数值
	 * 
	 *@author ZSM
	 * @param T
	 * @param X
	 */
	public void test1(int[] T,int X) {
//		int min = T[0];
//		int max=T[T.length-1];
		for(int i=0;i<T.length/2;i++) {
			int min = T[i];
			int max = X-min;
			for(int j=T.length-1;j>T.length/2;j--) {
				if(max==T[j]) {
					System.out.println(T[i]+"+"+T[j]+"=16");
					break;
				}
			}
			
		}
	}
	
	/**
	 * 先将X数拆分为一个数组，
	 * 将数组升序排序，
	 * 然后进行重组，
	 * 从前往后得到最小值，
	 * 从后往前得到最大值
	 *@author ZSM
	 * @param X
	 */
	public void run(int X) {
		int num = X;
		int[] array = new int[4];
		for(int i=0;i<4;i++) {
			num = num/10;
			array[i]=num;
		}
		 int temp = X%10;
	}
}
